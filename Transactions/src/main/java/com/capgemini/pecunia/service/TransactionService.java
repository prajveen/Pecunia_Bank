package com.capgemini.pecunia.service;

import com.capgemini.pecunia.entity.Account;
import com.capgemini.pecunia.entity.ChequeTransactions;
import com.capgemini.pecunia.entity.SlipTransactions;

public interface TransactionService {


	String debitUsingSlip(SlipTransactions debit) ;
	

	String updateBalance(Account balance) ;


	Account getAccountbyID(String accountID);


	String debitUsingCheque(ChequeTransactions debit);


	String creditUsingCheque(ChequeTransactions credit);


	String creditUsingSlip(SlipTransactions credit);

}
