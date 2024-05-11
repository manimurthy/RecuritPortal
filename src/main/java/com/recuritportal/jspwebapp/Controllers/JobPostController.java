package com.recuritportal.jspwebapp.Controllers;

import java.io.Console;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Entity.JobPost1;
import com.recuritportal.jspwebapp.Entity.JobPostFAQ;
import com.recuritportal.jspwebapp.Service.JobPostService;

import jakarta.servlet.http.HttpSession;

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
    
    @GetMapping("/jobfirmdashboardview")
    public String firmDashboardView(Model model) {
        // Add necessary attributes to the model and return the view name
        return "jobDetailsView"; // This should be the name of the .html or .jsp file, if using templates
    }
    
	@PostMapping ("/savejobdetails")
	public String details(JobPost1 jobPost, Model model)
	{
		 jobpostService.insertJobPostDetails(jobPost);
		 model.addAttribute("error", "Job details posted  successfully!!! ");
		return "postjob";
	}	
	
	@PostMapping ("/searchjob_backup")
	public String details(@RequestParam String jobId, @RequestParam String jobDesc, Model model)
	{
        if (jobId != null && !jobId.isEmpty()) {
            // Only JobId is provided
            /* if (jobpostService.findByjobtitle(jobId)){
            	return  "firmdashboard";
            } else if (jobDesc != null) {
                jobpostService.findByjobdesc(jobDesc);
                return  "firmdashboard";
            }
            else {
                // Handle the case where neither is provided
                model.addAttribute("error", "No sufficient input provided");
                return "firmdashboard"; // Redirect to an error page or similar
            }*/     
        }	
       return "firmdashboard";
	}
	
    @GetMapping("/searchjob")
    public String searchJob(Model model, HttpSession session) {
        // Get the empname and empid from the session
        String empName = (String) session.getAttribute("empname");
        Integer empId = (Integer) session.getAttribute("empId");

        if (empId == null) {
        	model.addAttribute("error", "You are not logged in. Please log in to access this page.");
            return "redirect:/login"; 
        }
        // Add empname and empid to the model
        model.addAttribute("empName", empName);
        model.addAttribute("empId", empId);    	
    	        
        return "/searchjob"; // This should be the name of the .html or .jsp file, if using templates
    }
	
	@PostMapping ("/searchjobbyval")
	public String jobdetails(@RequestParam String jobId, @RequestParam String jobDesc, RedirectAttributes redirectAttributes)
	{
		 List<JobPost1> jobPost = null;
	        if (jobId != null) {
	            jobPost = jobpostService.findByjobtitle(jobId);
	        	//return "Hello";
	        } else if (jobDesc != null){
	            jobPost = jobpostService.findByjobdesc(jobDesc);
	        } /*else if   (jobId != null && jobDesc != null) {
		          //  jobPost = jobpostService.findByJobTitleAndDesc(jobId, jobDesc);
	        }*/
	        // Add jobPost to the model
	        //model.addAttribute("jobPost", jobPost);
	        redirectAttributes.addFlashAttribute("jobPost", jobPost);
	        //return "jobDetailsView";
	        return "redirect:/searchjob";
	}		
    
	@GetMapping("/postjob")
    public String firmPostJob(Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
		//get the firmid stored in the session  
		Integer firmId = (Integer) session.getAttribute("firmid");
        // If firm ID is null, redirect to login page with error message
        if (firmId == null) {
            redirectAttributes.addFlashAttribute("error", "You are not logged in. Please log in to access this page.");
            return "redirect:/login"; 
        }		
		 model.addAttribute("firmunqid", firmId); 
        // Add necessary attributes to the model and return the view name
        return "postjob"; // This should be the name of the .html or .jsp file, if using templates
    }
	
	@GetMapping("/faqjob")
    public String firmfaqJob(Model model) {
        // Add necessary attributes to the model and return the view name
        return "jobFAQFile"; // This should be the name of the .html or .jsp file, if using templates
    }
    
	@PostMapping("/saveFAQJob")
    public String saveJobPost(JobPost1 jobPost1, RedirectAttributes redirectAttributes) {
        for (JobPostFAQ faq : jobPost1.getFaqs()) {
            faq.setJobPost(jobPost1);
        }
		/*jobPost1.getFaqs().forEach(faq -> {
		        faq.setJobPost(jobPost1);  // Set the parent
		    });*/
        jobpostService.savefaq(jobPost1);
        redirectAttributes.addFlashAttribute("info","Job Post created successfully!!!");
        return "redirect:/postjob";
    }
}
