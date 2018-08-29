package com.wipro.ips.service;

import com.wipro.ips.entity.Applicant;
import com.wipro.ips.entity.ExternalReferral;
import com.wipro.ips.entity.InternalReferral;
import com.wipro.ips.exception.DataValidationException;

public class ProfileEvaluator{
	private int JobId;
	private String JobName;
	private String requiredSkill;
	private int expMinExperience;
	private int expMaxExperience;
	
	public int getJobId() {
		return JobId;
	}

	public void setJobId(int jobId) {
		JobId = jobId;
	}

	public String getJobName() {
		return JobName;
	}

	public void setJobName(String jobName) {
		JobName = jobName;
	}

	public String getRequiredSkill() {
		return requiredSkill;
	}

	public void setRequiredSkill(String requiredSkill) {
		this.requiredSkill = requiredSkill;
	}

	public int getExpMinExperience() {
		return expMinExperience;
	}

	public void setExpMinExperience(int expMinExperience) {
		this.expMinExperience = expMinExperience;
	}

	public int getExpMaxExperience() {
		return expMaxExperience;
	}

	public void setExpMaxExperience(int expMaxExperience) {
		this.expMaxExperience = expMaxExperience;
	}

	public Applicant createObject(char referralType, int applicantId, String applicantName, int yrsOfExp, String skills, double expSalary,  String referralInfo) {
		Applicant applicant=null;
		if(referralType=='I') {
			applicant = new InternalReferral(applicantId, applicantName, yrsOfExp, skills, expSalary, Integer.parseInt(referralInfo));
		}
		else if(referralType=='E') {
			applicant =new ExternalReferral(applicantId, applicantName, yrsOfExp, skills, expSalary, referralInfo);
		}
		return applicant;
	}
	
	public String validateObject(Applicant applicant) throws DataValidationException{
		if((applicant==null)||(applicant.getApplicantName()==null)) {
			throw new DataValidationException();
		}
		else if(applicant.getYrsOfExp()<=0) {
			return "INVALID EXPERIENCE";
		}
		else if((applicant.getExpectedSalary()<0)) {
			return "INVALID SALARY";
		}
		else {
		return "VALID";
		}
		
	}
	
	public String processProfile(Applicant applicant) {
		String [] result =  getRequiredSkill().split(",");
		int count = 0;
		for(int i=0;i<result.length;i++){
	        if(applicant.getSkills().contains(result[i])){
	            count++;
	        }   
		}
		if((applicant.getYrsOfExp()<getExpMaxExperience()&&applicant.getYrsOfExp()>getExpMinExperience())==false) {
			
			return "NON ELIGIBLE EXPERIENCE";
		}
		else if(count != result.length) {
			return "NON ELIGIBLE SKILLS";
		}
		
		else {
			return "SELECTED";
		}
	}
}


