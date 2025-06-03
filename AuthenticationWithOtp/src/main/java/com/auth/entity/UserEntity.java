package com.auth.entity;

import com.auth.util.Generate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_user")
public class UserEntity {
	
	
	
	   @Id
	   private String user_id;
	    private String email;
	    private String otp;
	    private long otpGeneratedTime;
	    
		  @PrePersist
	    public void generateId() {
	        if (this.user_id == null) {
	        	 long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
	            this.user_id = String.format("%10d", number);
	        }}
	    
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getOtp() {
			return otp;
		}
		public void setOtp(String otp) {
			this.otp = otp;
		}
		public long getOtpGeneratedTime() {
			return otpGeneratedTime;
		}
		public void setOtpGeneratedTime(long otpGeneratedTime) {
			this.otpGeneratedTime = otpGeneratedTime;
		}


}
