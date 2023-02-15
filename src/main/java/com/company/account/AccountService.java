package com.company.account;

import java.io.FileWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import jakarta.transaction.Transactional;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository repository;

	@Transactional
	public void createAccount(int start, int end) {
		List<Account> accountLst = new ArrayList<Account>();
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		 for(long i=start; i<end;i++) {
			 Account account = new Account();
			 account.setAcType("SBA");
			 account.setAcNumber(String.valueOf(Math.ceil(Math.random())));
			 account.setAcOpenedDate(LocalDateTime.now());
			 account.setBankName("BankName"+i);
			 account.setBranchName("BranchName"+i);
			 account.setBranchCode(String.valueOf(i));
			 account.setAddress1(String.valueOf(i));
			 account.setAddress2(String.valueOf(i));
			 account.setLandmark("LandMark"+i);
			 account.setCity("City"+i);
			 account.setState("State"+i);
			 account.setCountry("Country"+i);
			 account.setZipCode("ZipCode"+i);
			 account.setContactPerson("ContactPerson"+i);
			 account.setPhoneNumber("PhoneNumber"+i);
			 account.setEMail("EMail"+i);
			 account.setIsActive(true);
			 account.setCreatedBy("SYSTEM");
			 account.setCreatedDate(timestamp);
			 account.setUpdatedBy("SYSTEM");
			 account.setUpdatedDate(timestamp);
			 
			 accountLst.add(account);
		 }
		 
		 repository.saveAll(accountLst);
	}
	
	public void generateCSVFile() {
		long startTime = System.currentTimeMillis();
		List<Account> accountList = repository.findAll();
		long endTime = System.currentTimeMillis();
		long timeTaken = (endTime-startTime)/1000;
		System.out.println("Metrics: For Reading startTime:  "+startTime+"   endTime: "+endTime+
				"	timeTaken: "+timeTaken+"	accountList  size: "+accountList.size());
		startTime = System.currentTimeMillis();
		System.out.println("Metrics: For Writing CSV startTime:  "+startTime);
		
		try {
			Writer writer = new FileWriter("employees.csv");
			StatefulBeanToCsv<Account> beanToCsv = new StatefulBeanToCsvBuilder<Account>(writer).build();
			beanToCsv.write(accountList);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		endTime = System.currentTimeMillis();
		timeTaken = (endTime-startTime)/1000;
		System.out.println(startTime+"   endTime: "+endTime+
				"	timeTaken: "+timeTaken+"	accountList  size: "+accountList.size());
	}

}
