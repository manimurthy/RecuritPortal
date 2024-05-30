package com.recuritportal.jspwebapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Repository.JobFaqRepo;
import com.recuritportal.jspwebapp.Repository.JobPostRepo;

@Service
public class JobPostService {
	@Autowired
	private JobPostRepo jobRepo;
	private JobFaqRepo  jobfaqRepo;
	
	public JobPostService(JobPostRepo jp,   JobFaqRepo jp1)
	{
		this.jobRepo = jp;
		this.jobfaqRepo = jp1;
	}
    public boolean insertJobPostDetails(JobPost jobPost) {
        //Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
    	jobRepo.save(jobPost);
        return true;
    }    
    
    public List<JobPost>  findByjobdesc(String jobDesc) {
    	//List<JobPost> jobPostSrch = jobRepo.findByjobdesc(jobDesc);
    	List<JobPost> jobPostSrch = jobRepo.findByJobDescriptionContaining(jobDesc);
    	return jobPostSrch ;    			
    }
    public List<JobPost>  findByjobtitle(String jobTitle) {
    	List<JobPost> jobPostSrch = jobRepo.findByjobtitle(jobTitle);
    	return jobPostSrch;
    }
    /*public boolean  findByjobtitleanddesc(String jobTitle, String jobDesc) {
    	JobPost jobPostSrch = jobRepo.findByjobtitleanddesc(jobDesc);
    	return jobPostSrch!= null;
    }*/
    public List<JobPost>  findByfirm(int firmid) {
    	List<JobPost> jobPostSrch = jobRepo.findByfirmunqid(firmid);
    	return jobPostSrch ;    			
    }
    public List<JobPost>  findByAllPostedJob() {
    	List<JobPost> jobPostSrch = jobRepo.findByAllJobs();
    	return jobPostSrch ;    			
    }    
    
    public boolean savefaq(JobPost jobPost) {
        //Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
    	jobfaqRepo.save(jobPost);
        return true;
    }    
}
