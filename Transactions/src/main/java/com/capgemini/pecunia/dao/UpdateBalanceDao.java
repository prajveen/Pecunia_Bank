package com.capgemini.pecunia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.pecunia.entity.Account;

public interface UpdateBalanceDao extends JpaRepository<Account, String> {
	
	@Query("select f from Account f  where accountId =?1")
	Account getAccountbyID(String accountID);
	
	@Modifying
	@Query("update Account set amount=?2 where  account_Id=?1")
	void update(String accountId, Double amount);
	
	


}
