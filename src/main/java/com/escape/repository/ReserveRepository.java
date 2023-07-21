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
	@Query(value = "insert into reserve(name, cnt, modified_by, date ,update_time ,time, cal, price) values(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
	int updateres(String name, int cnt, String email,String date, LocalDateTime UpdateTime, String time , int cal, int price);
	
	
	@Query(value = "select * from reserve where theme_name = 'test'", nativeQuery = true)
	List<Reserve> getbtnList();
	
	@Query(value = "select * from reserve where theme_name = 'test'", nativeQuery = true)
	List<Reserve> getallList();
	
	
	List<Reserve> findByModifiedBy(String email);
	
	
	
	@Query(value = "select * from reserve where date = ?1 and time = ?2", nativeQuery = true)
	Reserve getwpqkfList(String date, String time);

	


	
}
