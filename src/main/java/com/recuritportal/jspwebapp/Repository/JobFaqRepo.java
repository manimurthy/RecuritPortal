package com.recuritportal.jspwebapp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.recuritportal.jspwebapp.Entity.JobPost1;

public interface JobFaqRepo  extends CrudRepository<JobPost1, Integer>{
	JobPost1  findByjobpostingid( Integer jobpostingid);
	List<JobPost1>  findByjobtitle( String jobTitle);
	List<JobPost1> findByjobdesc(String jobDesc);
}
