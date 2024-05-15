package com.recuritportal.jspwebapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.recuritportal.jspwebapp.Entity.JobApplied;

//public interface ApplyJobRepo extends CrudRepository<Applyjob, Integer> {
public interface ApplyJobRepo extends CrudRepository<JobApplied, Integer> {

	List<JobApplied> findByEmployee_Empid(Integer empid);

    @Modifying
    @Query("UPDATE JobApplied j SET j.status = :status WHERE j.jobapplyid = :jobapplyid")
    void updateStatusById(int jobapplyid, String status);
}
