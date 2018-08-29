package com.wipro.ips.entity;

public class InternalReferral extends Applicant {
	
	int employeeId;
	
	public InternalReferral(int applicantId, String applicantName, int yrsOfExp, String skills, double expSalary,int employeeId) {
		// TODO Auto-generated constructor stub
		super(applicantId, applicantName, yrsOfExp, skills, expSalary);
		this.employeeId = employeeId;
	}

	

}
