package com.aau.noticeboard.security;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;

@Data
public class SignUp{
    private String fullname;
    @Size(min = 3, message = "Need at least 3 characters")
    private String username;
    private String password;
    @Email(message = "Email invalid")
    private String email;
    

    User toUser(PasswordEncoder encoder) {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(encoder.encode(this.password));
        user.setFullname(this.fullname);
        user.setEmail(this.email);
        return user;
    }
}

