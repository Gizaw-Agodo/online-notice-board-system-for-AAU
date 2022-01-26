package com.aau.noticeboard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Noticeboard {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String officename ;
    private String username;     
}
