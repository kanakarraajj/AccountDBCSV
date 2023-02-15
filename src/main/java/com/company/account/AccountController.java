package com.company.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PatchMapping
	public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
		return new ResponseEntity<>(accountDTO,HttpStatus.CREATED);
	}
	
	//http://localhost:8181/accounts?start=10000&end=15000
	@PostMapping
	public ResponseEntity<AccountDTO> createAccount(@RequestParam int start, @RequestParam int end) {
		accountService.createAccount(start,end);
		System.out.println("AccountController - > createAccount  ->  COMPLETED "+start  +"  "+end);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	//http://localhost:8181/accounts 
	@GetMapping 
	public void generateCSVFile() {
		accountService.generateCSVFile();
	}

}
