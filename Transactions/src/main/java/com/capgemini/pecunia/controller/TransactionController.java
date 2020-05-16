package com.capgemini.pecunia.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entity.Account;
import com.capgemini.pecunia.entity.ChequeTransactions;
import com.capgemini.pecunia.entity.SlipTransactions;
import com.capgemini.pecunia.exceptions.IdNotFound;
import com.capgemini.pecunia.exceptions.InsufficientBalance;
import com.capgemini.pecunia.service.TransactionService;

@RestController
@RequestMapping("/transactions")
@CrossOrigin("http://localhost:4200")
public class TransactionController {

	@Autowired
	private TransactionService service;

	@PutMapping("/debitUsingSlip")
	public ResponseEntity<String> debitUsingSlip(@RequestBody SlipTransactions Debit) throws IdNotFound, InsufficientBalance  {
		Account account=service.getAccountbyID(Debit.getAccountNo());
		if(account==null) {
			throw new IdNotFound("Please enter valid accountId!");
		}
		else {
			if(account.getAmount()<=Debit.getAmount()) {
				throw new InsufficientBalance("Insufficient account balance");
			}
			else
			{
				ResponseEntity< String> details = new ResponseEntity<String>(service.debitUsingSlip(Debit),HttpStatus.OK);
				return details;
			}
		}
	}

	@PutMapping("/debitUsingCheque")
	public ResponseEntity<String> debitUsingCheque(@RequestBody ChequeTransactions Debit) throws IdNotFound, InsufficientBalance  {
		Account account=service.getAccountbyID(Debit.getPayeeAccountNo());
		if(account==null) {
			throw new IdNotFound("Please enter valid accountId!");
		}
		else {
			if(account.getAmount()<=Debit.getAmount()) {
				throw new InsufficientBalance("Insufficient account balance");
			}
			else
			{
				ResponseEntity< String> details = new ResponseEntity<String>(service.debitUsingCheque(Debit),HttpStatus.OK);
				return details;
			}
		}

	}

	@PutMapping("/creditUsingCheque")
	public ResponseEntity<String> creditUsingCheque(@RequestBody ChequeTransactions credit) throws InsufficientBalance, IdNotFound {
		Account account=service.getAccountbyID(credit.getPayeeAccountNo());
		if(account==null) {
			throw new IdNotFound("Please enter valid Payee Account No.!");
		}
		else {
			if(account.getAmount()<=credit.getAmount()) {
				throw new InsufficientBalance("Insufficient account balance in payee account");
			}
			else
			{
				ResponseEntity< String> details = new ResponseEntity<String>(service.creditUsingCheque(credit),HttpStatus.OK);
				return details;
			}
		}
	}

	@PutMapping("/creditUsingSlip")
	public ResponseEntity<String> creditUsingSlip(@RequestBody SlipTransactions credit) throws IdNotFound, InsufficientBalance{
		Account account=service.getAccountbyID(credit.getAccountNo());
		if(account==null) {
			throw new IdNotFound("Please enter valid accountId!");
		}
		else {
			ResponseEntity< String> details = new ResponseEntity<String>(service.creditUsingSlip(credit),HttpStatus.OK);
			return details;
		}
	}

	@PutMapping("/updateBalance")
	public ResponseEntity<String> updateBalance(@RequestBody Account balance) {
		ResponseEntity< String> response = new ResponseEntity<String>(service.updateBalance(balance),HttpStatus.OK);
		return response;	
	}

}




