package com.recuritportal.jspwebapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recuritportal.jspwebapp.Entity.Applyjob;
import com.recuritportal.jspwebapp.Entity.JobApplied;
import com.recuritportal.jspwebapp.Service.ApplyJobService;

@Controller
public class JobApplyController {
	@Autowired
	ApplyJobService applyjobService;
	
	public JobApplyController (ApplyJobService ajServ){
		this.applyjobService = ajServ;
	}
	
    @GetMapping("/applyjob")
    public String applyJob(Model model) {
        // Add necessary attributes to the model and return the view name
        return "/applyjobs"; // This should be the name of the .html or .jsp file, if using templates
    }
    
	@PostMapping ("/saveapplyjob")
	public String saveapplyjob(JobApplied jobPost, Model model)
	{
		applyjobService.insertApplyJob(jobPost);
		 model.addAttribute("info", "Job details posted  successfully!!! ");
		 return "redirect:/applyjob";
	}
	
    @GetMapping("/empappliedjob")
    public String getJobDetails(@RequestParam Integer empid, Model model) {
        List<JobApplied> jobApplications = applyjobService.getJobApplicationsByEmployeeId(empid);
        model.addAttribute("jobApplications", jobApplications);
        return "empappliedjobs"; // Return the name of your JSP file
    }	
	
}
