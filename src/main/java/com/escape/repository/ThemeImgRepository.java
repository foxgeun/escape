package com.escape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.escape.entity.Theme;
import com.escape.entity.ThemeImg;

public interface ThemeImgRepository extends JpaRepository<ThemeImg, String>{

	@Query(value = "select * from theme_img", nativeQuery = true)
	List<ThemeImg> getImgList();
	
	@Modifying
	@Query(value = "select * from theme_img where theme_img_id = ?1", nativeQuery = true)
	List<ThemeImg> SearchthemeIdList(int id);
	
	
	@Query(value = "select * from theme_img where theme_img_id = ?1", nativeQuery = true)
	ThemeImg SearchthemeIdList2(int id);
	
	@Query(value = "select * from theme_img where theme_img_id = ?1", nativeQuery = true)
	ThemeImg profileImg(int id);


}
