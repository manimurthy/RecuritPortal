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

}
