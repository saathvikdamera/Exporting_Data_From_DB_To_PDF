package com.Damera.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Course {
	
	@Id
	private Integer courseId;
	private String courseName;
	private Double price;

}
