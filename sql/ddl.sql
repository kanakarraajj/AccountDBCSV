create table account (
        id bigint not null,
        acType varchar(255),
        acNumber varchar(255),
		acOpenedDate timestamp(6),  
		acClosedDate timestamp(6),		
        bankName varchar(255),
        branchName varchar(255),
		branchCode varchar(255),
		address1 varchar(255),
        address2 varchar(255),
        landmark varchar(255),
        city varchar(255),
		state varchar(255),
        country varchar(255),
		zipCode varchar(255),

		phoneNumber varchar(255),
		contactPerson varchar(255),
		eMail varchar(255),
		
        createdBy varchar(255),
        createdDate timestamp(6),
        isActive boolean,
        
        remarks varchar(255),       
        status varchar(255),
        updatedBy varchar(255),
        updatedDate timestamp(6),        
        primary key (id)
    );
	 