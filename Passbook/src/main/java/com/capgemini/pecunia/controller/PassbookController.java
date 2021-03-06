package com.capgemini.pecunia.controller;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entities.Transactions;
import com.capgemini.pecunia.exceptions.IdNotFound;

import com.capgemini.pecunia.service.PassbookMaintenanceService;



@RestController
@RequestMapping("/passbook")
@CrossOrigin("http://localhost:4200")
public class PassbookController {
	
	@Autowired
	private PassbookMaintenanceService service;

	
	//Fetching the transactions till last updated date
	@GetMapping("/updatePassbook/{accountId}")
	public  ResponseEntity<List<Transactions>> updatePassbook(@PathVariable("accountId") String accountId) throws  IdNotFound
	{
		boolean result=service.accountValidation(accountId);
		 if(result==true) {
			List<Transactions> list = service.updatePassbook(accountId);
			return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}
		else {
			throw new IdNotFound("AccountId does not exists!");
		}
	}
	
	//Fetching transactions between two dates
	@GetMapping("/accountSummary/{accountId}/{startDate}/{endDate}")
	public ResponseEntity<List<Transactions>> accountSummary(@PathVariable String accountId, @PathVariable Date startDate, @PathVariable Date endDate) throws  IdNotFound 
	{
		boolean result=service.accountValidation(accountId);
		 if (result==true) {
			List<Transactions> list = service.accountSummary(accountId, startDate, endDate);
			return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
		}
		else {
			throw new IdNotFound("AccountId does not exists!");
		}

	}
}
		

