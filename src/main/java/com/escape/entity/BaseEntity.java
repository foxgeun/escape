package com.escape.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
@Setter
public abstract class BaseEntity extends BaseTimeEntity {
	
	
	
	@CreatedBy
	@Column(updatable = false)
	private String createBy;
	
	
	@LastModifiedBy
	private String modifiedBy;
	
	
	
	
}
