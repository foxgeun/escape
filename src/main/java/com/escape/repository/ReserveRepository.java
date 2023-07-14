package com.escape.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


import com.escape.entity.Reserve;



public interface ReserveRepository extends JpaRepository<Reserve, Long>, QuerydslPredicateExecutor<Reserve>{

	
	@Query(value = "select * from reserve", nativeQuery = true)
	List<Reserve> getresList();	
	
	
	@Modifying
	@Query(value = "update reserve set name = ?1, cnt = ?2, modified_by = ?3,  update_time = ?4 where time = ?5", nativeQuery = true)
	int updateres(String name, int cnt, String email, LocalDateTime UpdateTime, String time);
	
	
	
	List<Reserve> findByModifiedBy(String email);



	
}
