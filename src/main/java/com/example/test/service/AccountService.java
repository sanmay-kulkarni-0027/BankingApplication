package com.example.test.service;

import org.springframework.data.repository.CrudRepository;

import com.example.test.Entity.Account;

public interface AccountService extends CrudRepository<Account,Long>{

	
	
}
