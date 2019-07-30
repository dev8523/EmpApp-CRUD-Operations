/**
 * @author Debasish Sahoo
 * @description This is a POJO class for Employee registration.
 *
 */

package com.infinite.EmpApp.bean;

public class Employee {

	String empId;
	String empPassword;
	String empFN;
	String empLN;
	float empSal;
	String doj;
	String dob;
	String gender;
	String uploadResume;
	String empEmail;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpFN() {
		return empFN;
	}

	public void setEmpFN(String empFN) {
		this.empFN = empFN;
	}

	public String getEmpLN() {
		return empLN;
	}

	public void setEmpLN(String empLN) {
		this.empLN = empLN;
	}

	public float getEmpSal() {
		return empSal;
	}

	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUploadResume() {
		return uploadResume;
	}

	public void setUploadResume(String uploadResume) {
		this.uploadResume = uploadResume;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empPassword=" + empPassword + ", empFN=" + empFN + ", empLN=" + empLN
				+ ", empSal=" + empSal + ", doj=" + doj + ", dob=" + dob + ", gender=" + gender + ", uploadResume="
				+ uploadResume + ", empEmail=" + empEmail + "]";
	}

	public Employee(String empId, String empPassword, String empFN, String empLN, float empSal, String doj, String dob,
			String gender, String uploadResume, String empEmail) {
		super();
		this.empId = empId;
		this.empPassword = empPassword;
		this.empFN = empFN;
		this.empLN = empLN;
		this.empSal = empSal;
		this.doj = doj;
		this.dob = dob;
		this.gender = gender;
		this.uploadResume = uploadResume;
		this.empEmail = empEmail;
	}

}
