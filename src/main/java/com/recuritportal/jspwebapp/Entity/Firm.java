package com.recuritportal.jspwebapp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Firm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int firmid;
	@Column
	private String firmemail;
	@Column
	private String firmname;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String contactnumber;
	@Column
	private String contactperson;
	@Column
	private String password;
	
	public int getFirmid() {
		return firmid;
	}
	public void setFirmid(int firmid) {
		this.firmid = firmid;
	}
	public String getFirmemail() {
		return firmemail;
	}
	public void setFirmemail(String firmemail) {
		this.firmemail = firmemail;
	}
	public String getFirmname() {
		return firmname;
	}
	public void setFirmname(String firmname) {
		this.firmname = firmname;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
