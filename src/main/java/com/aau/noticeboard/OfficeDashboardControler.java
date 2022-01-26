package com.aau.noticeboard;

import java.util.List;


import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
@SessionAttributes("noticeboard")
public class OfficeDashboardControler {
    private final NoticeboardRepository repository;
    private final NoticeboardRepository boardrepo;
    private final NoticeRepository noticerepo; 
    

    @RequestMapping ("/offices")
    public String storeBoard(@ModelAttribute("office")  @Param("username") String keyword,  Noticeboard board ,Model model){
        this.boardrepo.save(board);
        
        Noticeboard noticeboard = this.boardrepo.findByUsername(keyword);
        model.addAttribute("noticeboards", noticeboard);
        return "offices";
        }
  

    String temp2 ; 
    @RequestMapping ("/offices2")
    public String storeNotice( @Param("keyword") String keyword,  @ModelAttribute ("offices2") Notice notice, Model model){
        temp2 = keyword;
        notice.setReference(keyword);
        this.noticerepo.save(notice);
        
        List<Notice> notices =  this.noticerepo.searchNotice(keyword);
        model.addAttribute("notices", notices);
        return "offices";
        }
    


     @PostMapping("delete")
    public String delete(@RequestParam long offId, Model model){
       this.noticerepo.deleteById(offId);
        
       List<Notice> notices = this.noticerepo.searchNotice(temp2);
       model.addAttribute("notices", notices);
       return "offices";
        }



    @RequestMapping("/search2")
    public String  searchBoard(@Param("keyword") String keyword , Model model) {
        
         List<Noticeboard> noticeboards = this.repository.search(keyword);
         model.addAttribute("keyword" ,keyword);
         model.addAttribute("noticeboards", noticeboards);
         
         return "UserDashboard";
        }


     
}
