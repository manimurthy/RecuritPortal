package com.recuritportal.jspwebapp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.recuritportal.jspwebapp.Entity.Applyjob;
import com.recuritportal.jspwebapp.Entity.JobApplied;

//public interface ApplyJobRepo extends CrudRepository<Applyjob, Integer> {
public interface ApplyJobRepo extends CrudRepository<JobApplied, Integer> {

	List<JobApplied> findByEmployee_Empid(Integer empid);

}
