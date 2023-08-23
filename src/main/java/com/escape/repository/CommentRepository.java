package com.escape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.escape.entity.Comment;




public interface CommentRepository extends JpaRepository<Comment, String>{

	
	@Query(value = "select * from comment where theme = ?1", nativeQuery = true)
	List<Comment> commentList(String theme);
	
	
}
