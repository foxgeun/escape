package com.escape.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.*;

@EntityListeners(value = {AuditingEntityListener.class})  //auditing적용
@MappedSuperclass  //부모 클래스를 상속받는 자식 클래스한테 매핑정보를 제공하기 위해
@Getter
@Setter
public abstract class BaseTimeEntity {
	
	@CreatedDate //엔티티가 생성되서 저장될때 시간을 자동으로 저장한다.
	@Column(updatable = false)
	private LocalDateTime regTime;  //등록날짜
	
	
	@LastModifiedDate  //엔티티가 수정될때 시간을 자동으로 저장한다.
	private LocalDateTime updateTime; //수정날짜
	
	
	
	
}