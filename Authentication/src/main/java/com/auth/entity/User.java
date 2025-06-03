package com.auth.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.auth.helper.Generate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="tb_user1")
public class User {
	
	@Id
	private String user_id;
	
//	  @PrePersist
//	    public void generateId() {
//	        if (this.user_id == null) {
//	        	 long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
//	            this.user_id = String.format("%10d", number);
//	        }}
	
	
	private String username;
	private String emailid;
	
	private LocalDateTime updateon;
	private LocalDateTime createon;
	private String password;
	private String role;
	private long otpGenerationTime;
	private String otp;
	
	
	
	@Transient
	private Generate generate = new Generate(); 

	public User() {
		this.user_id = new Generate().generateId();
	}

	public void setOtpGenerationTime(long otpGenerationTime) {
	    this.otpGenerationTime = otpGenerationTime;
	}
	public long getOtpGenerationTime() {
		return otpGenerationTime;
	}


	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	public String getUser_id() {
	return user_id;
}
//public void setUser_id(String user_id) {
//	this.user_id = user_id;
//}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public LocalDateTime getUpdateon() {
		return updateon;
	}
	public void setUpdateon(LocalDateTime updateon) {
		this.updateon = updateon;
	}
	public LocalDateTime getCreateon() {
		return createon;
	}
	public void setCreateon(LocalDateTime createon) {
		this.createon = createon;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


}
