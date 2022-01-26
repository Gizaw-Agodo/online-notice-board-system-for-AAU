package com.aau.noticeboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface NoticeRepository  extends CrudRepository<Notice,Long> {
   
   Notice findById(String id);

   @Query( "SELECT notice FROM Notice notice WHERE notice.reference LIKE %?1% " )
    public  List<Notice> searchNotice(String keyword);

}
