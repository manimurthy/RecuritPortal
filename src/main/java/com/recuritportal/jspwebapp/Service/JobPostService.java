package com.recuritportal.jspwebapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Entity.JobPost1;
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
    public boolean insertJobPostDetails(JobPost1 jobPost) {
        //Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
    	jobRepo.save(jobPost);
        return true;
    }    
    
    public List<JobPost1>  findByjobdesc(String jobDesc) {
    	//List<JobPost1> jobPostSrch = jobRepo.findByjobdesc(jobDesc);
    	List<JobPost1> jobPostSrch = jobRepo.findByJobDescriptionContaining(jobDesc);
    	return jobPostSrch ;    			
    }
    public List<JobPost1>  findByjobtitle(String jobTitle) {
    	List<JobPost1> jobPostSrch = jobRepo.findByjobtitle(jobTitle);
    	return jobPostSrch;
    }
    /*public boolean  findByjobtitleanddesc(String jobTitle, String jobDesc) {
    	JobPost jobPostSrch = jobRepo.findByjobtitleanddesc(jobDesc);
    	return jobPostSrch!= null;
    }*/
    public List<JobPost1>  findByfirm(String firmid) {
    	List<JobPost1> jobPostSrch = jobRepo.findByfirmunqid(firmid);
    	return jobPostSrch ;    			
    }
    public List<JobPost1>  findByAllPostedJob() {
    	List<JobPost1> jobPostSrch = jobRepo.findByAllJobs();
    	return jobPostSrch ;    			
    }    
    
    public boolean savefaq(JobPost1 jobPost1) {
        //Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
    	jobfaqRepo.save(jobPost1);
        return true;
    }    
}
