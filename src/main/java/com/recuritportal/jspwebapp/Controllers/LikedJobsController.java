package com.recuritportal.jspwebapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Entity.JobPost1;
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
    
	/*@RequestMapping("/likedjobs")
	public String showLoginForm() {
	    return "emplikedjobs";
	}*/
    
    
	//@GetMapping("/employeeLikedJobs")
    @GetMapping("/likedjobs")
    //public String showEmployeeLikedJobs(@RequestParam Integer empID, Model model ) {
    public String showEmployeeLikedJobs( Model model , HttpSession session) {
    	
    	Integer empid = (Integer) session.getAttribute("empId");

            if (empid == null) {
            	model.addAttribute("error", "You are not logged in. Please log in to access this page.");
                return "redirect:/login"; 
            }    		    	
        List<JobPost1> likedJobs = likedJobsService.getLikedJobsForEmployee(empid);
        model.addAttribute("likedJobs", likedJobs);
        return "emplikedjobs"; // return the name of the JSP file
    }	
}

