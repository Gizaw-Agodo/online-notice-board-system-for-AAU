package com.aau.noticeboard;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface NoticeboardRepository extends CrudRepository<Noticeboard,Long> {


     @Query( "SELECT bord FROM Noticeboard bord WHERE bord.username LIKE %?1% ")
    public  List<Noticeboard> search(String keyword);

      public Noticeboard findByUsername(String username);

}
