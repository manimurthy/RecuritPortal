package com.recuritportal.jspwebapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recuritportal.jspwebapp.Entity.*;
//import com.recuritportal.jspwebapp.Repository.EmployeeRepo;
import com.recuritportal.jspwebapp.Service.*;
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
    
    @RequestMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String empemail, @RequestParam String password, @RequestParam(required = false) String emptype, Model model) {
        //Employee employee = employeeRepo.findByEmpemailAndPassword(empemail, password);
       if ("Employee".equals(emptype.trim())) {
    	if (empService.validateCredentials(empemail, password)) {
            // Valid credentials, redirect to main empdashboard page
           // return "redirect:employeedashboard";
        	return "redirect:empdashboard";
        } else {
            // Invalid credentials, show error message
            model.addAttribute("error", "Invalid credentials!! Please try again");
            return "login";
        }
       } else {
           if (firmService.validatefirmCredentials(empemail, password)) {
             //  return "redirect:firmdashboard";
        	   return "redirect:searchjob";
           } else {
               model.addAttribute("error", "Invalid Firm credentials!! Please try again");
               return "login";
           }    	   
    	   
       }
       
    }
    
    @GetMapping("/empdashboard")
    public String showLandingPage() {
        return "empdashboard"; // Assuming "landing.html" is the name of your landing page HTML file
    }    
    
    @GetMapping("/firmdashboard")
    public String firmDashboard(Model model) {
        // Add necessary attributes to the model and return the view name
        return "firmdashboard"; // This should be the name of the .html or .jsp file, if using templates
    }
    
/*	@RequestMapping ("/empreg")
	public String details()
	{
		return "empreg";
	}
*/	
	@PostMapping ("/savedetails")
	public String details(Employee empReg, Model model)
	{
		if (empService.checkEmployeeExists(empReg.getEmpemail()) )	{
			model.addAttribute("error", "This email is already registered. Please login in directly.");
			return  "login";
		}
		 empService.insertEmployeeDetails(empReg);
		 model.addAttribute("info", "You have been registered successfully!!! Please go and login.");
		return "login";
	}    
}
