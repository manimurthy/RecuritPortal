package com.recuritportal.jspwebapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recuritportal.jspwebapp.Entity.Applyjob;
import com.recuritportal.jspwebapp.Entity.Employee;
import com.recuritportal.jspwebapp.Entity.JobApplied;
import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Service.ApplyJobService;
import com.recuritportal.jspwebapp.Service.EmployeeService;
import com.recuritportal.jspwebapp.Service.InsertApplyService;
import com.recuritportal.jspwebapp.Service.JobPostService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class JobApplyController {
	@Autowired
	ApplyJobService applyjobService;
	InsertApplyService insertapplyService;
	EmployeeService empService;
    
	@PersistenceContext
    private EntityManager entityManager;
	
	public JobApplyController (ApplyJobService ajServ,InsertApplyService jpServ,EmployeeService eServ ){
		this.applyjobService = ajServ;
		this.insertapplyService = jpServ;
		this.empService = eServ;
	}
	
    
    @GetMapping("/applyjobid")
    public String applyJob(@RequestParam Integer jobpostingid, @RequestParam String skillname, Model model, HttpSession session) {
        // Add necessary attributes to the model and return the view name
        String empName = (String) session.getAttribute("empname");
        Integer empId = (Integer) session.getAttribute("empId");
        
    	model.addAttribute("jobpostingid", jobpostingid);
    	model.addAttribute("skillname",skillname);
        model.addAttribute("empName", empName);
    	model.addAttribute("empid", empId);
        return "/applyjobs"; // This should be the name of the .html or .jsp file, if using templates
    }  
	
    @Transactional
    @PostMapping("/saveapplyjob")
    public String saveApplyJob(@RequestParam("job_post_id") int jobPostId, 
                               @RequestParam("empid") int empId,
                               @RequestParam("applieddate") String appliedDate,
                               @RequestParam("noofyearsofexp") int noOfYearsOfExp,
                               @RequestParam("eduqualify") String eduQualify,
                               @RequestParam("expinskills") int expInSkills,
                               @RequestParam("miscinfo") String miscInfo,
                               @RequestParam("status") String status,
                               Model model) {
        // Create a new JobApplied object
        JobApplied jobApplied = new JobApplied();

        // Set the jobPost property by creating a new JobPost object with the specified ID
        //JobPost jobPost = new JobPost();
     // Fetch JobPost entity from the database
        JobPost jobPost = entityManager.find(JobPost.class, jobPostId);
     // Fetch Employee entity from the database
        Employee employee = entityManager.find(Employee.class, empId);
        // Set the merged JobPost entity to the JobApplied entity
        jobApplied.setJobPost(jobPost);
        jobApplied.setEmployee(employee);
        // Set other properties of the jobApplied object
        jobApplied.setApplieddate(appliedDate);
        jobApplied.setNoofyearsofexp(noOfYearsOfExp);
        jobApplied.setEduqualify(eduQualify);
        jobApplied.setExpinskills(expInSkills);
        jobApplied.setMiscinfo(miscInfo);
        jobApplied.setStatus(status);
        // Save the jobApplied object
        applyjobService.insertApplyJob(jobApplied);
        // Add a success message to the model
        model.addAttribute("info", "Job details posted successfully!!!");

        return "redirect:/empappliedjob";
    }
    
    @GetMapping("/empappliedjob")
    public String getJobDetails(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    	
        String empName = (String) session.getAttribute("empname");
        Integer empId = (Integer) session.getAttribute("empId");
        
            if (empId == null) {
            	redirectAttributes.addFlashAttribute("error", "You are not logged in. Please log in to access this page.");
                return "redirect:/login"; 
            }    		
         
        List<JobApplied> jobApplications = applyjobService.getJobApplicationsByEmployeeId(empId);
        model.addAttribute("empName", empName);
        model.addAttribute("empId", empId);        
        model.addAttribute("jobApplications", jobApplications);
        return "empappliedjobs"; // Return the name of your JSP file
    }
    
    @GetMapping("/firmappliedjob")
    public String getfirmJobDetails(@RequestParam Integer jobpostingid, Model model, HttpSession session,RedirectAttributes redirectAttributes) {
    	Integer firmid = (Integer) session.getAttribute("firmid");

            if (firmid == null) {
            	redirectAttributes.addFlashAttribute ("error", "You are not logged in. Please log in to access this page.");
                return "redirect:/login"; 
            }    		
        //List<JobApplied> jobApplications = applyjobService.getJobApplicationsByPostingd(firmid);
        List<JobApplied> jobApplications = applyjobService.getJobApplicationsByPostingId(jobpostingid);
        
        // Sort the jobApplications list by calcTotalWeight
        jobApplications.sort((a, b) -> Integer.compare(b.getCalcTotalWeight(), a.getCalcTotalWeight()));
      
        model.addAttribute("jobApplications", jobApplications);
        return "jobappliedselection"; // Return the name of your JSP file
    }	    
    @GetMapping("/getdtlsforapplyjob")
    public String getJobDetailsForApply(@RequestParam Integer jobpostingid, RedirectAttributes redirectAttributes) {
        JobPost jobpost = applyjobService.getJobDtlsForApply(jobpostingid);
        redirectAttributes.addAttribute("jobPostDtls", jobpost);
        return "redirect:/applyjobs"; // Return the name of your JSP file
    }		
    
    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam("jobapplyid") int jobApplyId,
                               @RequestParam("status") String status,@RequestParam("jobpostid") Integer jobpostid,  RedirectAttributes redirectAttributes, Model model,HttpSession session ) {

    	//Code for checking of the frim user has logged in. If not then send to login page
    	Integer firmid = (Integer) session.getAttribute("firmid");

            if (firmid == null) {
            	redirectAttributes.addFlashAttribute ("error", "You are not logged in. Please log in to access this page.");
                return "redirect:/login"; 
            }    		
            
    	applyjobService.updateStatus(jobApplyId, status);
    	List<JobApplied> jobApplications = applyjobService.getJobApplicationsByPostingId(jobpostid);
               
        model.addAttribute("jobApplications", jobApplications);
    	model.addAttribute("info", "Record updated successfully");
    	return "jobappliedselection";
    }    

    @GetMapping("/viewjobapplicationdetails")
    public String viewJobApplicationDetails(@RequestParam("jobapplyid") int jobapplyid, Model model, HttpSession session,RedirectAttributes redirectAttributes) {
    	Integer firmid = (Integer) session.getAttribute("firmid");

        if (firmid == null) {
        	redirectAttributes.addFlashAttribute ("error", "You are not logged in. Please log in to access this page.");
            return "redirect:/login"; 
        }    		    	
        JobApplied jobApplication = applyjobService.getJobApplicationById(jobapplyid);
        model.addAttribute("jobApplication", jobApplication);
        return "firmviewjobapplicationdtls";  // The new JSP view name
    }
    
    @GetMapping("/clacweightscore")
    public String getclacweightscore(@RequestParam Integer jobpostingid, Model model, HttpSession session,RedirectAttributes redirectAttributes) {
       
    	//Code for checking of the frim user has logged in. If not then send to login page
    	Integer firmid = (Integer) session.getAttribute("firmid");

            if (firmid == null) {
            	redirectAttributes.addFlashAttribute ("error", "You are not logged in. Please log in to access this page.");
                return "redirect:/login"; 
            }    		
        JobPost jobpost = applyjobService.getJobDtlsForApply(jobpostingid);
        List<JobApplied> jobApplications = applyjobService.getJobApplicationsByPostingId(jobpostingid);
        
        // Iterate over the job applications and call calcWeightandUpdate for each
        for (JobApplied jobApplied : jobApplications) {
            applyjobService.calcWeightandUpdate(jobpost, jobApplied);
        }
        //Display the success message
        redirectAttributes.addFlashAttribute ("info","Weigatge Calculation for applied jobs completed");
        return "redirect:/searchalljobsfirm"; 
    }
}
