package com.example.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.Entity.Account;
import com.example.test.service.AccountService;

@Service
public class ControllersService {

	@Autowired
	AccountService as;
	
	//creates new user account
	public Account createNewUser(Account account) {
		
		Account savedAcc=as.save(account);
		return savedAcc;
	}

	//retrieves user account by id
	public Account getAccountId(long acc_num) {
		// TODO Auto-generated method stub
		Optional<Account> gotAcc=as.findById(acc_num);
		return gotAcc.get();
	}

	
	//retrieves all users account
	public List<Account> getAllDetails() {
		// TODO Auto-generated method stub
		List<Account> acc=(List<Account>) as.findAll();
		return acc;
	}

	
	//amount deposites
	public Account depositeAmount(long acc_num,double acc_balance) {
		// TODO Auto-generated method stub
		Optional<Account> gotAcc=as.findById(acc_num);
//		if(gotAcc.isEmpty()) {
//			throw new RuntimeException("Account is not present");
//		}
		Account ac=gotAcc.get();
		double totalBalance=ac.getAcc_balance()+acc_balance;
		ac.setAcc_balance(totalBalance);
		as.save(ac);
		return ac;
		
	}

	
	//amount withdraws
	public Account withdrawAmount(long acc_num, double acc_balance) {
		// TODO Auto-generated method stub
		Optional<Account> gotAcc=as.findById(acc_num);
		Account ac=gotAcc.get();
		double totalBalance=ac.getAcc_balance()-acc_balance;
		ac.setAcc_balance(totalBalance);
		as.save(ac);
		return ac;
	
	}

	//deletes account
	public Account deleteAccount(long acc_num) {
	    // Fetch the account first
	    Account deletedAccount = as.findById(acc_num).orElse(null);
	    
	    // If the account exists, delete it
	    if (deletedAccount != null) {
	        as.deleteById(acc_num);
	    }
	    
	    // Return the deleted account (or null if it didn't exist)
	    return deletedAccount;
	}

	
	
	
}
