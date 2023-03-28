package com.Damera.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Damera.entities.Course;
import com.Damera.service.CourseService;
import com.Damera.util.PDFGenerator;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	
	@GetMapping("/export-to-pdf")
	public void generatePDF(HttpServletResponse response) throws IOException, Exception {
		response.setContentType("application/pdf");
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = df.format(new Date());
		String headerkey = "Content-Disposition";
	    String headervalue = "attachment; filename=student" + currentDateTime + ".pdf";
	    
	    List<Course> lstOfCourses = service.listAll();
	    PDFGenerator generator = new PDFGenerator();
	    generator.generate(lstOfCourses, response);
	}

}
