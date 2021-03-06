package com.capgemini.pecunia;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.entities.Transactions;


@SpringBootTest
class PecuniaPassbookApplicationTests {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void updatePassbookTestSuccess() throws URISyntaxException {

    final String baseUrl = "http://localhost:" + 1903 + "/passbook/updatePassbook/851990559410";
    URI uri = new URI(baseUrl);
    ResponseEntity<Transactions[]> result = restTemplate.getForEntity(uri, Transactions[].class);
    Assertions.assertEquals(200, result.getStatusCodeValue());

}

	@Test
	public void accountSummaryTestSuccesful() throws URISyntaxException {
	
    final String baseUrl = "http://localhost:" + 1903 + "/passbook/accountSummary/851990559410/2020-04-19/2020-04-23" ;
    URI uri = new URI(baseUrl);
    ResponseEntity<Transactions[]> result = restTemplate.getForEntity(uri, Transactions[].class);
    Assertions.assertEquals(200, result.getStatusCodeValue());
 
}

}
