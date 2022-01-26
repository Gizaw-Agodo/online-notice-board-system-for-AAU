package com.aau.noticeboard;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller

public class OfficeController {
    @Autowired
   othercontroller control;

    @Autowired
   private OfficeRepo OfficeRepository;

    @GetMapping("creat") 
    public String getForm(Model model){
        model.addAttribute("office",new Office());
    
        return "addofficeform";
    }

    @PostMapping("creat")
    public String rendermsg(@ModelAttribute @Valid Office newOffice,Errors errors,Model model){
       if(errors.hasErrors()){
           return "addofficeform";
       }
       OfficeRepository.save(newOffice);
      
        return "redirect:/fill";
    }


    @GetMapping("fill")
    public String showform(Model model){
        model.addAttribute("offices",OfficeRepository.findAll());
       
        return "adminBar";
   
    }
    
      
    

    @GetMapping("delete/{id}")
    public String deleteEntity(@PathVariable(value = "id") int id){
        OfficeRepository.deleteById(id);
        
       return "redirect:/fill";
        

    }

    

    @GetMapping("update/{id}")
    public String update(@PathVariable int id,Model model){
     Office office2 = control.findByOfficeId(id);
     model.addAttribute("office", office2);
      
       return "updateform";
        

    }
    @GetMapping("submit/{id}")
    public String updateForm(@ModelAttribute @Valid Office newOffice,Errors errors,@PathVariable int id,Model model){
        if(errors.hasErrors()){
          
               return "updateform";
           }
        OfficeRepository.save(newOffice);
        return "redirect:/fill";
    }
}