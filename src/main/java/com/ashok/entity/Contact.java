package com.ashok.entity;

import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Contact {
	@Id
	@GeneratedValue
	private int cid;
	private String name;
	private String email;
	private long mobNo;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime creationTime;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime upDateTime;
	private String status;
	

}
