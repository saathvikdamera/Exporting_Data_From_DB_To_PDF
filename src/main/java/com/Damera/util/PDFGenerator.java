package com.Damera.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.Damera.entities.Course;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFGenerator {
	
	public void generate(List<Course> lstOfCourses,HttpServletResponse response) throws Exception, IOException {
		
		Document doc = new Document(PageSize.A4);
		
		PdfWriter.getInstance(doc, response.getOutputStream());
		
		doc.open();
		
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);
		
		Paragraph paragraph1 = new Paragraph("List of Courses",fontTitle);
		
		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
		
		doc.add(paragraph1);
		
		PdfPTable table = new PdfPTable(3);
		
		table.setWidthPercentage(100f);
		table.setWidths(new int[] {3,3,3});
		table.setSpacingBefore(5);
		
		PdfPCell cell = new PdfPCell();
		
		cell.setBackgroundColor(CMYKColor.BLUE);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);
		
		cell.setPhrase(new Phrase("Course Id",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Course Name",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Price",font));
		table.addCell(cell);
		
		for(Course c : lstOfCourses) {
			table.addCell(String.valueOf(c.getCourseId()));
			table.addCell(c.getCourseName());
			table.addCell(String.valueOf(c.getPrice()));
		}
		
		doc.add(table);
		
		doc.close();
		
	}

}
