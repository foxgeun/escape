package com.escape.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escape.entity.Comment;
import com.escape.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
	private final CommentRepository commentRepository;
	
	public List<Comment> CommentList(String theme) {
		return commentRepository.commentList(theme);
	}
	
	
}
