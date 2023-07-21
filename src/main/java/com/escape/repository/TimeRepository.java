package com.escape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.escape.entity.Time;

public interface TimeRepository extends JpaRepository<Time, String> {
	
	
	@Query(value = "select * from time", nativeQuery = true)
	List<Time> getTimeList();
	
	
	
}
