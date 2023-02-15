package com.company.account;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	public AccountDTO mapToDTO(Account account) {
		return modelMapper.map(account, AccountDTO.class);
	}
	
	public Account mapToEntity(AccountDTO account) {
		return modelMapper.map(account, Account.class);
	}

}
