package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Entity.Account;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	ControllersService cs;
	
	
	//creates new user
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		
		Account nacc=cs.createNewUser(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(nacc);
	}
	
	
	//retrieves user details by id
	@GetMapping("/get/{id}")
	public Account getAccountDetails(@PathVariable("id")long acc_num) {
		Account gt=cs.getAccountId(acc_num);
		return gt;
	}
	
	//retrieves all users
	@GetMapping("/get/all")
     public List<Account> getAllAccounts(){
		
		List<Account> list=cs.getAllDetails();
		
		return list;
		
	}
	
	
	//depositing money in bank account
	@PutMapping("/deposite/{id}/{balance}")
	public Account depositeMoney(@PathVariable("id")long acc_num,@PathVariable("balance")double acc_balance) {
		
		Account newacc=cs.depositeAmount(acc_num,acc_balance);
		return newacc;
			
	}
	
	
	//withdraw money from bank account
	@PutMapping("/withdraw/{id}/{balance}")
    public Account withdrawMoney(@PathVariable("id")long acc_num,@PathVariable("balance")double acc_balance) {
		
		Account newacc=cs.withdrawAmount(acc_num,acc_balance);
		return newacc;
			
	}
	
	//delete account
	@DeleteMapping("/delete/{id}")
	public Account deleteAccount(@PathVariable("id")long acc_num) {
		Account deletedac=cs.deleteAccount(acc_num);
		return deletedac;
	}
	
	
}
