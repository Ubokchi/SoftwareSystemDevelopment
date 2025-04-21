package org.springframework.samples.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

//import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletContext;

@Controller
public class ReportSubmissionController implements ApplicationContextAware {

	private WebApplicationContext context;	
	
	@Value("/upload/")
	private String uploadDir;

	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.context = (WebApplicationContext) appContext;
		ServletContext sc = context.getServletContext();
		this.uploadDir = sc.getRealPath(this.uploadDir);
	}

	@RequestMapping(value = "/report/submission.do", method = RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}

	@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(
			@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report, 
			Model model) {
		
		String filePath = uploadFile(studentNumber, report);		
		model.addAttribute("path", filePath);
		return "report/submissionComplete";
	}
	
	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request, Model model) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		
		String filePath = uploadFile(studentNumber, report);		
		model.addAttribute("path", filePath);
		return "report/submissionComplete";
	}

	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand, Model model) {
		String studentNumber = reportCommand.getStudentNumber();
		MultipartFile report = reportCommand.getReport();
		
		String filePath = uploadFile(studentNumber, report);		
		model.addAttribute("path", filePath);
		return "report/submissionComplete";
	}
	
	private String uploadFile(String studentNumber, MultipartFile report) {
		String filename = null;
		try {
			filename = new String(report.getOriginalFilename().getBytes("8859_1"),"utf-8");
			filename = report.getOriginalFilename();
			System.out.println(studentNumber + "가 업로드 한 파일: " + filename);
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		
		File file = new File(this.uploadDir + filename);
		try {
			report.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return file.getAbsolutePath();
	}
}
