package com.company.account;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccountDTO {
	
	private Long id;
	private Long acNumber;
	private String acType;
	private LocalDateTime acOpenedDate;
	private LocalDateTime acClosedDate;
	private Boolean isActive;
	private String status;
	private String remarks;
	private String createdBy;
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
	private LocalDateTime createdDate;
	private String updatedBy;
	private LocalDateTime updatedDate;

}
