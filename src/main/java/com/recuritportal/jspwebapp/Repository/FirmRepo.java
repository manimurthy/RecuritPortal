package com.recuritportal.jspwebapp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.recuritportal.jspwebapp.Entity.Firm;

public interface FirmRepo extends CrudRepository<Firm, Integer>{
	Firm findByFirmemailAndPassword(String firmemail, String password);

}
