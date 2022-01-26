package com.aau.noticeboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class HomeControler {
    
    
    @GetMapping("/adminnav")
    public String admin(){
        return "login";}
        

    @GetMapping("/officesnav")
    public String office(){
        return "login";}

    @GetMapping("/loginnav")
    public String loginnav(){
        return "login";}
    
   
    }
