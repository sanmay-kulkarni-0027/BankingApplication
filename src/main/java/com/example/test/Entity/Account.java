package com.example.test.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
	
	public Account() {
		
	}

	
	public Account(String acc_holder_name, double acc_balance) {
		super();
		this.acc_holder_name = acc_holder_name;
		this.acc_balance = acc_balance;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long acc_num;
	@Column
	private String acc_holder_name;
	@Column
	private double acc_balance;
	public long getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(long acc_num) {
		this.acc_num = acc_num;
	}
	public String getAcc_holder_name() {
		return acc_holder_name;
	}
	public void setAcc_holder_name(String acc_holder_name) {
		this.acc_holder_name = acc_holder_name;
	}
	public double getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}
	@Override
	public String toString() {
		return "Account [acc_num=" + acc_num + ", acc_holder_name=" + acc_holder_name + ", acc_balance=" + acc_balance
				+ "]";
	}
	
}
