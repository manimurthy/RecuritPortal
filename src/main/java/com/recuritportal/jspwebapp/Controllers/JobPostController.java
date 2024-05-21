package com.recuritportal.jspwebapp.Controllers;

import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recuritportal.jspwebapp.Entity.JobApplied;
import com.recuritportal.jspwebapp.Entity.JobPost1;
import com.recuritportal.jspwebapp.Entity.JobPostFAQ;
import com.recuritportal.jspwebapp.Service.ApplyJobService;
import com.recuritportal.jspwebapp.Service.JobPostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class JobPostController {
    @Autowired
    private JobPostService jobpostService ;
    private ApplyJobService applyJobService;
    
    public JobPostController( JobPostService jpService, ApplyJobService ajServ) {
    	this.jobpostService = jpService;
    	this.applyJobService = ajServ;
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
   // public String searchJob(@RequestParam Boolean fromsrch,Model model, HttpSession session) {
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
        //boolean fromsrch=false;
/*        if (!fromsrch) {
            List<JobPost1> jobPost = null;
        	jobPost = jobpostService.findByAllPostedJob();
        	if (jobPost ==null || jobPost.isEmpty()) {
        		model.addAttribute("info", "Did not find any posted jobs");
        	}
        	else {
            model.addAttribute("jobPost", jobPost);
        	}
        }*/
        
        List<JobPost1> jobPost = null;
    	jobPost = jobpostService.findByAllPostedJob();
    	if (jobPost ==null || jobPost.isEmpty()) {
    		model.addAttribute("info", "Did not find any posted jobs");
    	}
    	else {
        model.addAttribute("jobPost", jobPost);
    	}        

        return "/searchjob"; 
    }
	
	@PostMapping ("/searchjobbyval")
	public String jobdetails(@RequestParam String jobId, @RequestParam String jobDesc, RedirectAttributes redirectAttributes, Model model, HttpSession session)
	{
		
        String empName = (String) session.getAttribute("empname");
        Integer empId = (Integer) session.getAttribute("empId");

        if (empId == null) {
        	model.addAttribute("error", "You are not logged in. Please log in to access this page.");
            return "redirect:/login"; 
        }
        // Add empname and empid to the model
        model.addAttribute("empName", empName);
        model.addAttribute("empId", empId);
        
		 List<JobPost1> jobPost = null;
	        if (jobId != null && jobId !="") {
	            jobPost = jobpostService.findByjobtitle(jobId);
	        	//return "Hello";
	        } else if (jobDesc != null || jobDesc !=""){
	            jobPost = jobpostService.findByjobdesc(jobDesc);
	        } /*else if   (jobId != null && jobDesc != null) {
		          //  jobPost = jobpostService.findByJobTitleAndDesc(jobId, jobDesc);
	        }*/
	        // Add jobPost to the model
	        //model.addAttribute("jobPost", jobPost);
	        // Filter out jobs with applyByDate in the past
	        // Filter out jobs with applyByDate in the past
	        // Get the current date

	        // Define the DateTimeFormatter according to your date format, e.g., "yyyy-MM-dd"
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        
	        LocalDate today = LocalDate.now();
	        
	        //String datenow = today1.format(formatter);
	        //LocalDate today = LocalDate.parse(datenow,formatter);
	        
// Check of the jobPost that has passed the expirty Date and only display to the users        
	        jobPost = jobPost.stream()
	                .filter(job -> {
	                    try {
	                        LocalDate applyByDate = LocalDate.parse(job.getApplybydate(), formatter);
	                        return !applyByDate.isBefore(today);
	                    } catch (Exception e) {
	                        // If parsing fails, treat the date as invalid (exclude the job)
	                        return false;
	                    }
	                })
	                .collect(Collectors.toList());
	        
//Check of Job for this Emp has already applied for the job if so remove that record.
	        // Get the list of job IDs the employee has already applied to
	        List<Integer> appliedJobIds = applyJobService.findJobIdsByEmployeeId(empId);


	        // Filter out jobs the employee has already applied to
	        jobPost = jobPost.stream()
	                .filter(job -> !appliedJobIds.contains(job.getJobpostingid()))
	                .collect(Collectors.toList());	        
	        
        	if (jobPost ==null || jobPost.isEmpty()) {
        		//redirectAttributes.addAttribute("info", "Did not find any posted jobs for selected search criteria");
        		model.addAttribute("info", "Did not find any posted jobs for selected search criteria");
        	}
        	else {
        		//redirectAttributes.addFlashAttribute("jobPost", jobPost);
        		model.addAttribute("jobPost", jobPost);
        	}
	        //return "jobDetailsView";
	        //return "redirect:/searchjob?fromsrch=true";
        	return "searchjob"; 
	}		

	@GetMapping("/searchalljobsfirm")
    //@GetMapping("/firmhome")
    public String firmsearchJob(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		//get the firmid stored in the session  
		Integer firmId = (Integer) session.getAttribute("firmid");
        // If firm ID is null, redirect to login page with error message
        if (firmId == null) {
            redirectAttributes.addFlashAttribute("error", "You are not logged in. Please log in to access this page.");
            return "redirect:/login"; 
        }		
        List<JobPost1> jobPost =  jobpostService.findByfirm(firmId.toString());
        //redirectAttributes.addFlashAttribute("firmJobPosted", jobPost); 
        
        model.addAttribute("firmJobPosted", jobPost);
        // Add necessary attributes to the model and return the view name
        //return "redirect:/firmsearchjob";
       return "firmsearchjob";
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
