package com.recuritportal.jspwebapp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.recuritportal.jspwebapp.Entity.JobPost;

public interface JobFaqRepo  extends CrudRepository<JobPost, Integer>{
	JobPost  findByjobpostingid( Integer jobpostingid);
	List<JobPost>  findByjobtitle( String jobTitle);
	List<JobPost> findByjobdesc(String jobDesc);
}
