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
import com.recuritportal.jspwebapp.Entity.JobPost1;
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
	
    @GetMapping("/applyjob")
    public String applyJob(Model model) {
        // Add necessary attributes to the model and return the view name
        return "/applyjobs"; // This should be the name of the .html or .jsp file, if using templates
    }
    
    @GetMapping("/applyjobid")
    public String applyJob(@RequestParam Integer jobpostingid, Model model, HttpSession session) {
        // Add necessary attributes to the model and return the view name
    	Integer empid = (Integer) session.getAttribute("empId");
    	model.addAttribute("jobpostingid", jobpostingid);
    	model.addAttribute("empid", empid);
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
        //Employee emp = new Employee();
        // Set the jobPost property by creating a new JobPost1 object with the specified ID
        //JobPost1 jobPost = new JobPost1();
     // Fetch JobPost1 entity from the database
        JobPost1 jobPost = entityManager.find(JobPost1.class, jobPostId);
     // Fetch Employee entity from the database
        Employee employee = entityManager.find(Employee.class, empId);
        
        //jobPost.setJobpostingid(jobPostId);
        //emp.setEmpid(empId);
        
     // Merge the detached JobPost1 entity
        //JobPost1 mergedJobPost = entityManager.merge(jobPost);

        // Merge the detached JobPost1 entity
      //  Employee mergedEmployee = entityManager.merge(emp);

        // Set the merged JobPost1 entity to the JobApplied entity
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
        // Redirect to the applyjob page
        return "redirect:/applyjob";
    }
    
	/*
	 * @GetMapping("/empappliedjob") public String getJobDetails(@RequestParam
	 * Integer empid, Model model, HttpSession session) { if (empid ==0) { empid =
	 * (Integer) session.getAttribute("empId");
	 * 
	 * if (empid == null) { model.addAttribute("error",
	 * "You are not logged in. Please log in to access this page."); return
	 * "redirect:/login"; } } List<JobApplied> jobApplications =
	 * applyjobService.getJobApplicationsByEmployeeId(empid);
	 * model.addAttribute("jobApplications", jobApplications); return
	 * "empappliedjobs"; // Return the name of your JSP file }
	 */
    
    @GetMapping("/empappliedjob")
    public String getJobDetails(Model model, HttpSession session) {
    	Integer empid = (Integer) session.getAttribute("empId");

            if (empid == null) {
            	model.addAttribute("error", "You are not logged in. Please log in to access this page.");
                return "redirect:/login"; 
            }    		
        List<JobApplied> jobApplications = applyjobService.getJobApplicationsByEmployeeId(empid);
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
        model.addAttribute("jobApplications", jobApplications);
        return "jobappliedselection"; // Return the name of your JSP file
    }	    
    @GetMapping("/getdtlsforapplyjob")
    public String getJobDetailsForApply(@RequestParam Integer jobpostingid, RedirectAttributes redirectAttributes) {
        JobPost1 jobpost = applyjobService.getJobDtlsForApply(jobpostingid);
        redirectAttributes.addAttribute("jobPostDtls", jobpost);
        return "redirect:/applyjobs"; // Return the name of your JSP file
    }		
    
    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam("jobapplyid") int jobApplyId,
                               @RequestParam("status") String status, RedirectAttributes redirectAttributes) {
    	applyjobService.updateStatus(jobApplyId, status);
    	redirectAttributes.addFlashAttribute("info", "Record updated successfully");
        return "redirect:/firmappliedjob"; // Redirect to the job applications page after updating status
    }    
}
