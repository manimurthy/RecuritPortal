package com.recuritportal.jspwebapp.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Entity.JobPost1;

public interface JobPostRepo extends CrudRepository<JobPost1, Integer>{
	
	JobPost1  findByjobpostingid( Integer jobPostingId);
	List<JobPost1>  findByjobtitle( String jobTitle);
	List<JobPost1> findByjobdesc(String jobDesc);
	List<JobPost1> findByfirmunqid(String firmunqid);
	//JobPost  findByjobtitleanddesc(String jobDesc);
    @Query("SELECT j FROM JobPost1 j WHERE j.jobdesc LIKE %:keyword%")
    List<JobPost1> findByJobDescriptionContaining(String keyword);
    @Query("SELECT j FROM JobPost1 j ")
    List<JobPost1> findByAllJobs();
}
