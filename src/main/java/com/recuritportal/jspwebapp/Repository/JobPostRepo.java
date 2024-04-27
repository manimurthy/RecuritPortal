package com.recuritportal.jspwebapp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.recuritportal.jspwebapp.Entity.JobPost;

public interface JobPostRepo extends CrudRepository<JobPost, Integer>{

}
