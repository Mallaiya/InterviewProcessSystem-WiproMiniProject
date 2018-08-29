package com.wipro.ips.entity;

public class ExternalReferral extends Applicant {
	String agencyName;
	public ExternalReferral(int applicantId, String applicantName, int yrsOfExp, String skills, double expSalary,String agencyName) {
		// TODO Auto-generated constructor stub
		super(applicantId, applicantName, yrsOfExp, skills, expSalary);
		this.agencyName = agencyName;
	}
	
}
