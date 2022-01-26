package com.aau.noticeboard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Office {
    @Id
    @GeneratedValue
   private int id;
    static int nextId = 1;
    @NotBlank(message = "fill the field")
    @Size(min=5,max=20, message="please put the valid charactor size min-5 and max-20")
    private String officeName;//name
     @NotBlank(message = "fill the field")
     @Size(min=5,max=20, message="please put the valid charactor size ")
    private String school;
    @NotBlank(message = "fill the field")
    @Size(min=6,max=20, message="please put the valid charactor size ")
    private String username;
     @NotBlank(message = "fill the field")
     @Size(min=6,max=20, message="please put the valid charactor size ")
    private String password;
  
    public Office(String officeName,String school,String username,String password){
        
        this.officeName=officeName;
        this.username=username;
        this.password=password;
        this.school=school;
     
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public Office(){ }

  

}
