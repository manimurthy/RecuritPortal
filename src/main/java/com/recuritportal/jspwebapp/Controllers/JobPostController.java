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
import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Entity.JobPostFAQ;
import com.recuritportal.jspwebapp.Service.ApplyJobService;
import com.recuritportal.jspwebapp.Service.JobPostService;

import jakarta.servlet.http.HttpServletRequest;
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
    
	@PostMapping ("/savejobdetails")
	public String details(JobPost jobPost, Model model)
	{
		 jobpostService.insertJobPostDetails(jobPost);
		 model.addAttribute("error", "Job details posted  successfully!!! ");
		return "postjob";
	}	
	
	//Search for jobs that are posted on the site. Also check if the Apply by Date is not past and also check if this employee has already applied for the job
    @GetMapping("/searchjob")
    public String searchJob(Model model, HttpSession session,RedirectAttributes redirectAttributes ) {
        // Get the empname and empid from the session
    	
        String empName = (String) session.getAttribute("empname");
        Integer empId = (Integer) session.getAttribute("empId");

        if (empId == null) {
        	redirectAttributes.addFlashAttribute("error", "You are not logged in. Please log in to access this page.");
            return "redirect:/login"; 
        }
        // Add empname and empid to the model
        model.addAttribute("empName", empName);
        model.addAttribute("empId", empId);

        List<JobPost> jobPost = null;
    	jobPost = jobpostService.findByAllPostedJob();
    	
        // Define the DateTimeFormatter according to your date format, e.g., "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate today = LocalDate.now();
        
        //Check of the jobPost that has passed the expirty Date and only display to the users        
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
        
        //Check for data and return
    	if (jobPost ==null || jobPost.isEmpty()) {
    		model.addAttribute("info", "Did not find any posted jobs");
    	}
    	else {
        model.addAttribute("jobPost", jobPost);
    	}        

        return "/searchjob"; 
    }
	
  //Same functionality as searchJob but allows to search job by keywords for Job Description and Job Title by full value.
    @PostMapping("/searchjobbyval")
    public String jobdetails(@RequestParam String jobId, @RequestParam String jobDesc, RedirectAttributes redirectAttributes, Model model, HttpSession session, HttpServletRequest request) {
        try {
            String empName = (String) session.getAttribute("empname");
            Integer empId = (Integer) session.getAttribute("empId");

            if (empId == null) {
                model.addAttribute("error", "You are not logged in. Please log in to access this page.");
                return "redirect:/login";
            }
            // Add empname and empid to the model
            model.addAttribute("empName", empName);
            model.addAttribute("empId", empId);

            List<JobPost> jobPost;
            if (jobId != null && !jobId.isEmpty()) {
                jobPost = jobpostService.findByjobtitle(jobId);
            } else if (jobDesc != null && !jobDesc.isEmpty()) {
                jobPost = jobpostService.findByjobdesc(jobDesc);
            } else {
                model.addAttribute("error", "Invalid search criteria. Please provide either a job ID or job description.");
                return "searchjob";
            }

            // Filter out jobs with applyByDate in the past
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate today = LocalDate.now();

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

            // Check if Job for this Emp has already applied for the job if so remove that record.
            List<Integer> appliedJobIds = applyJobService.findJobIdsByEmployeeId(empId);

            jobPost = jobPost.stream()
                    .filter(job -> !appliedJobIds.contains(job.getJobpostingid()))
                    .collect(Collectors.toList());

            if (jobPost == null || jobPost.isEmpty()) {
                model.addAttribute("info", "Did not find any posted jobs for selected search criteria");
            } else {
                model.addAttribute("jobPost", jobPost);
            }
            return "searchjob";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while fetching job all details as per the given values: " + e.getMessage());
            String referer = request.getHeader("Referer");
            model.addAttribute("referer", referer);
            return "error"; // You need to have an error.jsp page to display this message
        }
    }
		

	@GetMapping("/searchalljobsfirm")
    public String firmsearchJob(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		//get the firmid stored in the session  
		String firmname = (String) session.getAttribute("firmname");
		Integer firmId = (Integer) session.getAttribute("firmid");
        // If firm ID is null, redirect to login page with error message
        if (firmId == null) {
            redirectAttributes.addFlashAttribute("error", "You are not logged in. Please log in to access this page.");
            return "redirect:/login"; 
        }		
        
        List<JobPost> jobPost =  jobpostService.findByfirm(firmId);
        
        model.addAttribute("firmname",firmname);
        model.addAttribute("firmid",firmId);
        model.addAttribute("firmJobPosted", jobPost);
        // Add necessary attributes to the model and return the view name

       return "firmsearchjob";
    }
	
	@GetMapping("/postjob")
    public String firmPostJob(Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
		//get the firmid  and firmname stored in the session  
		String firmname = (String) session.getAttribute("firmname");
		Integer firmId = (Integer) session.getAttribute("firmid");
        // If firm ID is null, redirect to login page with error message
        if (firmId == null) {
            redirectAttributes.addFlashAttribute("error", "You are not logged in. Please log in to access this page.");
            return "redirect:/login"; 
        }
        model.addAttribute("firmname", firmname);
        model.addAttribute("firmid", firmId);
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
    public String saveJobPost(JobPost jobPost, RedirectAttributes redirectAttributes, Model model, HttpServletRequest request) {
		try {
		        for (JobPostFAQ faq : jobPost.getFaqs()) {
		            faq.setJobPost(jobPost);
		        }
		
		        jobpostService.savefaq(jobPost);
		        redirectAttributes.addFlashAttribute("info","Job Post created successfully!!!");
		        return "redirect:/postjob";
		    } catch (Exception e) {
		        model.addAttribute("error", "An error occurred while saving the job post: " + e.getMessage());
		        String referer = request.getHeader("Referer");
		        model.addAttribute("referer", referer);
		        return "error"; // You need to have an error.jsp page to display this message
		    }
    }
}
