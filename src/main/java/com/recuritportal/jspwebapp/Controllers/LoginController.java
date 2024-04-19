package com.recuritportal.jspwebapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.recuritportal.jspwebapp.Entity.*;
import com.recuritportal.jspwebapp.Repository.EmployeeRepo;
import org.springframework.ui.Model;


//#import ch.qos.logback.core.model.Model;

@Controller
public class LoginController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @RequestMapping("/login")
    public String showLoginForm() {
        System.out.println("You have to see login form here");
    	return "login";
    }
    
    @RequestMapping("/abcd")
    public String showabcdForm() {
    	return "abcdlogin";
    }
    @PostMapping("/login")
    public String login(@RequestParam String empemail, @RequestParam String password, Model model) {
        Employee employee = employeeRepo.findByEmpemailAndPassword(empemail, password);
        if (employee != null) {
            // Valid credentials, redirect to main landing page
            return "redirect:landing";
        } else {
            // Invalid credentials, show error message
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
    @GetMapping("/landing")
    public String showLandingPage() {
        return "landing"; // Assuming "landing.html" is the name of your landing page HTML file
    }    
}
