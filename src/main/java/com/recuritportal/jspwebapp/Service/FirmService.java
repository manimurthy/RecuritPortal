package com.recuritportal.jspwebapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recuritportal.jspwebapp.Entity.Firm;
import com.recuritportal.jspwebapp.Repository.FirmRepo;

@Service
public class FirmService {
    @Autowired
    private FirmRepo firmRepo ;

    public int validatefirmCredentials(String firmemail, String password) {
        Firm firm= firmRepo.findByFirmemailAndPassword(firmemail, password);
        //return firm.firmid;
        return 1;
    }    
}
