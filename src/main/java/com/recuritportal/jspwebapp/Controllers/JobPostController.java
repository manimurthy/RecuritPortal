package com.recuritportal.jspwebapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Service.JobPostService;

@Controller
public class JobPostController {
    @Autowired
    private JobPostService jobpostService ;
    
    public JobPostController( JobPostService jpService) {
    	this.jobpostService = jpService;
    } 
    @GetMapping("/jobfirmdashboard")
    public String firmDashboard(Model model) {
        // Add necessary attributes to the model and return the view name
        return "firmdashboard"; // This should be the name of the .html or .jsp file, if using templates
    }
    
	@PostMapping ("/savejobdetails")
	public String details(JobPost jobPost, Model model)
	{
		 jobpostService.insertJobPostDetails(jobPost);
		 model.addAttribute("error", "Job details posted  successfully!!! ");
		return "firmdashboard";
	}	

}
