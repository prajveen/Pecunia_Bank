package com.capgemini.pecunia.service;

import com.capgemini.pecunia.entity.Customer;

public interface AccountManagementService {

	String addAccount(Customer customer);

	Customer findByAccountId(String accountId);

	String updateAccount(String accountId, String customerName, String contactNumber, String address);

	String deleteAccount(String accountId);

	

}
