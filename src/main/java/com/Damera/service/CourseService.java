package com.Damera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Damera.entities.Course;
import com.Damera.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repo;
	
	public List<Course> listAll(){
		return repo.findAll();
	}

}
