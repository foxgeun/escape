package com.escape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escape.entity.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {
	
	
	@Query(value = "select * from time", nativeQuery = true)
	List<Time> getTimeList();
	
	@Query(value = "select * from time where time.time = :time", nativeQuery = true)
	Time getTime(@Param("time") String time);
	
}
