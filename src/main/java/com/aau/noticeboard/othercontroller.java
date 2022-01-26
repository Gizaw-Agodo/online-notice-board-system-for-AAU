package com.aau.noticeboard;

import java.util.Optional;
import com.aau.noticeboard.Security.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import lombok.Data;
@Controller
@Data
public class othercontroller {
    @Autowired
    private OfficeRepo OfficeRepository;
@Autowired
private UserRepository userRepository;


public User findByUserId(Long id){
    Optional<User> returneUser = userRepository.findById(id) ; 
    User userdata= returneUser.get();
    return  userdata;
}


    public Office findByOfficeId(int id){
      
        Optional<Office> returnedOffice = OfficeRepository.findById(id);
        Office office = returnedOffice.get();
        return office;

    }
    

 

}

