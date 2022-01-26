
package com.aau.noticeboard.security;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {
// first wirk
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm() {
        return "signUp";
        }



    @PostMapping
    public String processRegistration( @Valid SignUp form, Errors errors) {  
        
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/loginnav"; 
        }
  
}
