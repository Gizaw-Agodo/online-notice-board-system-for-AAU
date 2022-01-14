package com.aau.noticeboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userDashbordControler {
    
    @GetMapping("/")
    public String userDashboard(){
        return "userDashboard";
    }
}
