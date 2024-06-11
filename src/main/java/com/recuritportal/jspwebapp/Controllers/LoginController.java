package com.recuritportal.jspwebapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recuritportal.jspwebapp.Entity.*;
//import com.recuritportal.jspwebapp.Repository.EmployeeRepo;
import com.recuritportal.jspwebapp.Service.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


//#import ch.qos.logback.core.model.Model;

@Controller
public class LoginController {
    @Autowired
    private FirmService firmService;
    private EmployeeService empService;
   
    public LoginController(FirmService userService, EmployeeService emailService) {
        this.firmService = userService;
        this.empService = emailService;
    }
    
    @GetMapping("/")
    public String showLoginPage() {
        return "login"; // Assuming your login page is named "login.jsp" or "login.html"
    }
    
    @RequestMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String empemail, @RequestParam String password, @RequestParam(required = false) String emptype,RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request, Model model) {
    	Firm firm;
    	Employee emp;
    	try {
			        if ("Employee".equals(emptype.trim())) {
			        // If the selected option is Employee
			    	   emp = empService.validateCredentials(empemail, password);
				    	if (emp != null) {
				     	   redirectAttributes.addFlashAttribute("empdtl", emp);
				           session.setAttribute("empId",emp.getEmpid());
				           session.setAttribute("empname",emp.getFirstname());
				           session.setAttribute("usertype","Employee");
				           return "redirect:/searchjob";
				        } else {
				            // Invalid credentials, show error message
				        	redirectAttributes.addFlashAttribute("error", "Invalid credentials!! Please try again");
				            return "redirect:/";
				        }
			       } else {
			    	   		// If the selected option is Firm
				    	   firm = firmService.validatefirmCredentials(empemail, password);
				           if (firm != null) {
				        	   redirectAttributes.addFlashAttribute("firmdtl", firm);
					           session.setAttribute("firmid",firm.getFirmid());
					           session.setAttribute("usertype","Firm");	 
					           session.setAttribute("firmname",  firm.getFirmname());
				        	   return "redirect:/firmhome";
				           } else {
				        	   redirectAttributes.addFlashAttribute("error", "Invalid Firm credentials!! Please try again");
				               return "redirect:/";
				           }    	   
			       	}
			    } catch (Exception e) {
			    	String referer = request.getHeader("Referer");
			    	model.addAttribute("error", "An error occurred while processing your request: " + e.getMessage());
			    	model.addAttribute("referer", referer);
			        return "error"; // Load the error with the error message
			    }
    }
       
    @GetMapping("/firmhome")
    public String firmHome(Model model) {
        // Add necessary attributes to the model and return the view name
        return "redirect:/searchalljobsfirm"; 
    }
    
    @GetMapping("/emphome")
    public String empHome(Model model) {
        // Add necessary attributes to the model and return the view name
        return "emplikedjobs"; // 
    }        

	@PostMapping ("/savedetails")
	public String details(Employee empReg, Model model, HttpServletRequest request)
	{
		try {
			int a =  5/0;
			if (empService.checkEmployeeExists(empReg.getEmpemail()) )	{
				model.addAttribute("error", "This email is already registered. Please login in directly.");
				return  "login";
			}
			 empService.insertEmployeeDetails(empReg);
			 model.addAttribute("info", "You have been registered successfully!!! Please go and login.");
			return "login";
		}catch (Exception e) {
			model.addAttribute("error", "An error occurred while processing your request: " + e.getMessage());
	        String referer = request.getHeader("Referer");
	        model.addAttribute("referer", referer);
	        return "error"; // Load the error with the error message
	    }
	}    
	
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
		
        if (session != null) {
            session.invalidate(); // This line invalidates the session, effectively deleting all session attributes
        }
        model.addAttribute("info", "You have been successfully logged out! Login once again to continue");
        return "login"; // Redirect to login page 
    }	
    
    // Method to handle edit request
    @GetMapping("/editEmployee")
    public String editEmployee(@RequestParam("empid") Integer empid, Model model, HttpServletRequest request) {
    	
    	try {
		        Employee employee = empService.getEmployeeById(empid);
		        model.addAttribute("employee", employee);
		        return "empedit"; 
    		}catch (Exception e) {
    			model.addAttribute("error", "An error occurred while processing your request: " + e.getMessage());
		        String referer = request.getHeader("Referer");
		        model.addAttribute("referer", referer);
		        return "error"; // Load the error with the error message
		    }
    }    
    
	@PostMapping ("/updatedetails")
	public String updatedetails(Employee empReg, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request)
	{
		try {
		empService.insertEmployeeDetails(empReg);
		 redirectAttributes.addFlashAttribute("info", "Your profile has been updated successfully. Please continue to search for your dream job!");
		 return "redirect:/searchjob";
		}catch (Exception e) {
			model.addAttribute("error", "An error occurred while processing your request: " + e.getMessage());
	        String referer = request.getHeader("Referer");
	        model.addAttribute("referer", referer);
	        return "error"; // Load the error with the error message
	    }
	}    
	
}
