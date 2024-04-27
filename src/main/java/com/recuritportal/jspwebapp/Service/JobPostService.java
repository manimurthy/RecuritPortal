package com.recuritportal.jspwebapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Repository.JobPostRepo;

@Service
public class JobPostService {
	@Autowired
	private JobPostRepo jobRepo;
	
	
    public boolean insertJobPostDetails(JobPost jobPost) {
        //Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
    	jobRepo.save(jobPost);
        return true;
    }    

}
