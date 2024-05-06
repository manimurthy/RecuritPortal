package com.recuritportal.jspwebapp.Repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.recuritportal.jspwebapp.Entity.JobPost;

public interface JobPostRepo extends CrudRepository<JobPost, Integer>{
	
	JobPost  findByjobpostingid( Integer jobPostingId);
	List<JobPost>  findByjobtitle( String jobTitle);
	List<JobPost> findByjobdesc(String jobDesc);
	//JobPost  findByjobtitleanddesc(String jobDesc);
}
