package com.company.account;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="account")
@Data
@DynamicInsert
@DynamicUpdate
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String acNumber;
	private String acType;
	private LocalDateTime acOpenedDate;
	private LocalDateTime acClosedDate;
	private String status;
	private String remarks;
	private String bankName;
	private String branchName;
	private String branchCode;
	private String address1;
	private String address2;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String phoneNumber;
	private String contactPerson;
	private String eMail;
	private Boolean isActive;
	private String createdBy;
	private Timestamp createdDate;
	private String updatedBy;
	private Timestamp updatedDate;

}
