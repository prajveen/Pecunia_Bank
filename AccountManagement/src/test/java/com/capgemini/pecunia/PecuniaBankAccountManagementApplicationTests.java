package com.capgemini.pecunia;

import java.net.URI;
import java.net.URISyntaxException;

//import junit.framework.Assert;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.entity.Account;
import com.capgemini.pecunia.entity.Customer;


@SpringBootTest
class PecuniaBankAccountManagementApplicationTests {

	//@Autowired
	//private AccountManagementService service;
	
	@Test
	public void addAccount() throws URISyntaxException  {
		
		
		 /*
		    Customer customer=new Customer();
			Account account=new Account();
			account.setAccountId("112233445566");
			account.setAccountType("savings");
			account.setBranch("Hyd");
			account.setAmount((long) 200);
			customer.setAadharNumber("258963147753");
			customer.setCustomerName("Karthik");
			customer.setUserName("Karthikeya");
			customer.setContactNumber("7659873099");
			customer.setPanNumber("abvgft123");
			customer.setDateOfBirth("03-JAN-1999");
			customer.setGender("male");
			customer.setAddress("Khammam");
			customer.setAccount(account);
	        
			String result=service.addAccount(customer);
	        Assert.assertEquals(" account created succesfull ",result);*/
		
	        
	       RestTemplate restTemplate = new RestTemplate();
		     
		    final String baseUrl = "http://localhost:" + 2001 + "/AccountManagement/create";
		    URI uri = new URI(baseUrl);
		 
		    Customer customer=new Customer();
			Account account=new Account();
			account.setAccountId("112233445566");
			account.setAccountType("savings");
			account.setBranch("Hyd");
			account.setAmount((long) 200);
			customer.setAadharNumber("258963147753");
			customer.setCustomerName("Karthik");
			customer.setUserName("Karthikeya");
			customer.setContactNumber("7659873099");
			customer.setPanNumber("abvgft123");
			customer.setDateOfBirth("03-JAN-1999");
			customer.setGender("male");
			customer.setAddress("Khammam");
			customer.setAccount(account);
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "account successfully created ");      
	        HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
	        
	        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	        Assert.assertEquals(200, result.getStatusCodeValue());
		    Assert.assertNotNull(customer);
	}
	
	@Test
	public void showAccountDetailsTest() throws URISyntaxException {
		RestTemplate restTemplate=new RestTemplate();
		final String Url= "http://localhost:2001/AccountManagement/find/999999999999";
		URI uri=new URI(Url);
		 ResponseEntity<Customer> result = restTemplate.getForEntity(uri, Customer.class);
		    Customer customer = result.getBody();
		    Assert.assertEquals(200, result.getStatusCodeValue());
		    Assert.assertNotNull(customer);
		    
		    //Customer result4=service. findByAccountId("999999999999");
	        //Assertions.assertEquals("succesfull ",result4);
	}
	
	@Test
	public void updateAccount() throws URISyntaxException{

		RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 2001 + "/AccountManagement/update/999999999999/Karthik/7659873099/Khammam";
	    URI uri = new URI(baseUrl);
	 
	    Customer customer=new Customer();
        
		HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-MERGE", "successfully updated");      
        HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
        
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertNotNull(customer);
	    
	    
	    //String result3=service.updateAccount("\"112233445566","Harini","7659873099","Hyd");
        //Assertions.assertEquals(" account updated succesfull ",result3);
   	 }
	
	@Test
	public void deleteAccountTest() throws URISyntaxException {
		RestTemplate restTemplate=new RestTemplate();
		final String Url= "http://localhost:2001/AccountManagement/delete/112233445566";
		URI uri=new URI(Url);
		ResponseEntity<String> result=restTemplate.exchange(uri,HttpMethod.DELETE,null,String.class);
		 Assert.assertEquals(200, result.getStatusCodeValue());
		    
				
				
				//String result1=service.deleteAccount("112233445566");
		        //Assertions.assertEquals(" account deleted succesfull ",result1);
	}

}
