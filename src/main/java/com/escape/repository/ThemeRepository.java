package com.escape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.escape.entity.Reserve;
import com.escape.entity.Theme;
import com.escape.entity.ThemeImg;

public interface ThemeRepository extends JpaRepository<Theme, String>{

	@Query(value = "select * from theme", nativeQuery = true)
	List<Theme> getThemeList();

	
	@Modifying
	@Query(value = "select * from theme where name = ?1", nativeQuery = true)
	List<Theme> SearchthemeIdList(String themeName);

	
	@Modifying
	@Query(value = "select * from theme where theme_id = ?1", nativeQuery = true)
	List<Theme> SearchthemeIdList2(int id);
	
	

	@Query(value = "select * from theme where theme_id = ?1", nativeQuery = true)
	Theme SearchthemeIdList4(int id);
	
	@Modifying
	@Query(value = "select * from theme where theme_id = ?1", nativeQuery = true)
	List<Theme> SearchthemeIdList3(int id);
	
	
	@Query(value = "select * from theme where theme_id = ?1", nativeQuery = true)
	Theme updateList(int id);
	

	
}
