package com.recuritportal.jspwebapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Entity.LikedJobs;
import com.recuritportal.jspwebapp.Service.JobPostService;
import com.recuritportal.jspwebapp.Service.LikedJobService;

import jakarta.servlet.http.HttpSession;


@Controller
public class LikedJobsController {
    @Autowired
    JobPostService jpService;
    LikedJobService likedJobsService;
    
    public LikedJobsController(JobPostService jpServ, LikedJobService ljServ)
    {
    	jpService = jpServ;
    	likedJobsService = ljServ;
    }
    @GetMapping("/likedjobs")
    public String showEmployeeLikedJobs( RedirectAttributes redirectAttributes , HttpSession session, Model model) {
    	
        String empName = (String) session.getAttribute("empname");
    	Integer empId = (Integer) session.getAttribute("empId");

            if (empId == null) {
            	redirectAttributes.addFlashAttribute("error", "You are not logged in. Please log in to access this page.");						
                return "redirect:/login"; 
            }    		    	
            
        model.addAttribute("empName", empName);
        model.addAttribute("empId", empId);            
        List<JobPost> likedJobs = likedJobsService.getLikedJobsForEmployee(empId);
        model.addAttribute("likedJobs", likedJobs);
        return "emplikedjobs"; // return the name of the JSP file
    }	

    @GetMapping("/savelikejob")
    public String saveLikeJob(@RequestParam int jobPostId, HttpSession session,RedirectAttributes redirectAttributes) {

    	Integer empid = (Integer) session.getAttribute("empId");

        if (empid == null) {
        	redirectAttributes.addFlashAttribute("error", "You are not logged in. Please log in to access this page.");
            return "redirect:/login"; 
        }    		
    	LikedJobs likeJob = new LikedJobs();
    	likeJob.setJobID(jobPostId);
    	likeJob.setEmpID(empid);
    	likedJobsService.insertLikedJobs(likeJob);
    	redirectAttributes.addFlashAttribute("info", "This job is marked as your liked job. You will see all the liked jobs under liked jobs menu.");    	
    	//return "redirect:/likedjobs";
    	return "redirect:/searchjob?fromsrch=false";
    }
}

