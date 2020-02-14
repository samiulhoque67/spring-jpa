package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Student;
import com.luv2code.springboot.thymeleafdemo.service.Studentservice;

@Controller
public class DemoController {

	// create a mapping for "/hello"
	/*/
	@RequestMapping("/hello")
	public String sayHello() {
		
		//theModel.addAttribute("theDate", new java.util.Date());
		
		return "helloworld";
	}
	/*/
	
	
	
	private Studentservice studentservice;
	
	@Autowired
	public DemoController(Studentservice studentservice) {
		
		this.studentservice = studentservice;
	}

	@RequestMapping("/student1")
	  public String greetingForm(Model model) {
	    model.addAttribute("student", new Student());
	    return "greeting";
	  }

	 @RequestMapping("/list")
		public String listCustomers(Model theModel) {
			
			// get customers from the dao
			List<Student> student = studentservice.getStudents();
					
			// add the customers to the model
			theModel.addAttribute("student",student);
			
			return "list";
		}
	 
	 
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int theId,
									Model theModel) {
		
		// get the customer from our service
		Student student = studentservice.get(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("student", student);
		
		// send over to our form		
		return "greeting";
	}
	
	  @RequestMapping("/student")
	  public String greetingSubmit(@ModelAttribute Student student) {

		  studentservice.saveStudent(student);
	    return "redirect:/list";
	  }
	  @GetMapping("/delete")
	public String delete(@RequestParam("id") int theId) {
			
			// delete the customer
		  studentservice.delete(theId);
			
			return "redirect:/list";
		}
	  
	  @RequestMapping("/mail")
	 public String mail(@RequestParam("id") int theId,Model model) {
		  
		 Student student= studentservice.sendmail(theId);
		// System.out.println(user);
		 model.addAttribute("student",student);
		  return "email-confirmation" ;
	  }
	  
}




