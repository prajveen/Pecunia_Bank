package com.capgemini.pecunia.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.pecunia.entities.Transactions;

public interface PassbookMaintenanceService {

	public List<Transactions> updatePassbook(String accountId);
	
	public void updatelastUpdated(String accountId);

	public List<Transactions> accountSummary(String accountId, Date startDate, Date endDate);

	boolean accountValidation(String accountId);

}
