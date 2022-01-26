package com.aau.noticeboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import javax.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.security.Principal;
import java.util.List;

import com.aau.noticeboard.security.User;
import com.aau.noticeboard.security.UserRepository;


@Controller
@RequiredArgsConstructor
public class UserDashbordControler {
    PasswordEncoder encoder;
    @Autowired
    private final NoticeboardRepository repository;
    private final NoticeRepository noticerepo; 
    private final UserRepository userRepo;
@Autowired
othercontroller controller;

   String temp;
   @RequestMapping("/search")
   public String  searchBoard(@Param("keyword") String keyword , Model model) {
        temp = keyword;
        
        List<Noticeboard> noticeboards = this.repository.search(keyword);
        model.addAttribute("keyword" ,keyword);
        model.addAttribute("noticeboards", noticeboards);
        return "UserDashboard";
        }


   @RequestMapping("/result")
    public String searchNotice(@Param("keyword") String keyword,  @ModelAttribute ("offices2") Notice notice, Model model ){

        List<Noticeboard> noticeboards = this.repository.search(temp);
        model.addAttribute("keyword" ,temp);
        model.addAttribute("noticeboards", noticeboards);

        List<Notice> notices =  this.noticerepo.searchNotice(keyword);
        model.addAttribute("notices", notices);

        return "UserDashboard";
        }
        

        

   @RequestMapping("loginnav")
   public String login(){
       return "login";
   }
    

@GetMapping("editprofile/{id}")
public String editprofile(@PathVariable Long id,Model model){
    User newUser = controller.findByUserId(id);
    model.addAttribute("user", newUser);
    return "profileEditor";
}

@GetMapping("editSubmit/{id}")
public String updateForm(@ModelAttribute @Valid User newUser,Errors errors,Model model){
   
    if(errors.hasErrors()){
      
           return "profileEditor";
       }
    
    userRepo.save(newUser);
    return "redirect:/check";
}
    @RequestMapping("/login")
   public String Logn(@Param("username") String username, Model model) {
    return "login";

   }



  @RequestMapping("/cheak")
    public String Logn(@Param("username") String username) {
            
            User user = this.userRepo.findByUsername("username");
            if (user.getRole().equals("ADMIN")){
                return " adminBar";}

            else if  (user.getRole().equals("OFFICE")){
                return "offices";
            }
            return "UserDashboard";
        }


    @RequestMapping(value = "/check")
    public String profile(Principal principal, Model model){
        String username = principal.getName();
        User currentUser = (User) userRepo.findByUsername(username);
      
        if(currentUser.getRole().equals("ADMIN")){
            model.addAttribute("user", userRepo.findByUsername(username));
            return "adminBar";
            }

        else if (currentUser.getRole().equals("OFFICES")) {
            model.addAttribute("user", userRepo.findByUsername(username));
        
            return "offices";
        }
        model.addAttribute("user", userRepo.findByUsername(username));
        model.addAttribute("user2", currentUser);
        return "UserDashboard";

    }
}