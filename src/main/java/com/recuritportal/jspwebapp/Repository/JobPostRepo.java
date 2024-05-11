package com.recuritportal.jspwebapp.Repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Entity.JobPost1;

public interface JobPostRepo extends CrudRepository<JobPost1, Integer>{
	
	JobPost1  findByjobpostingid( Integer jobPostingId);
	List<JobPost1>  findByjobtitle( String jobTitle);
	List<JobPost1> findByjobdesc(String jobDesc);
	//JobPost  findByjobtitleanddesc(String jobDesc);
}
