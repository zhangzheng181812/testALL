package com.demo;

import com.demo.entity.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by admin on 2017/7/6.
 */
public interface LogRepository extends JpaRepository<Log,Long>{

    @Query("from Log")
    List<Log> findById(Pageable pageable);
}
