package com.slk.springrestclient.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.slk.springrestclient.model.Bugs;
import com.slk.springrestclient.model.TicketResolve;
import com.slk.springrestclient.model.TicketRise;

@Service
public class BugServiceRestClientImpl implements BugService {

	private RestTemplate restTemplate;

	private String btsRestUrl;

	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public BugServiceRestClientImpl(RestTemplate theRestTemplate, @Value("${bts.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		btsRestUrl = theUrl;

		logger.info("Loaded property:  bts.rest.url=" + btsRestUrl);
	}

	@Override
	public List<Bugs> getBugs() {

		logger.info("in getBugs(): Calling REST API " + btsRestUrl);

		// make REST call

		ResponseEntity<List<Bugs>> responseEntity = restTemplate.exchange(btsRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Bugs>>() {
				});

		// get the list of customers from response
		List<Bugs> bugs = responseEntity.getBody();

		logger.info("in getBugs(): bugs" + bugs);

		return bugs;
	}

	@Override
	public Bugs getBugsById(int theBugId) {

		logger.info("in getBugsById(): Calling REST API " + btsRestUrl);

		// make REST call
		Bugs theBugs = restTemplate.getForObject(btsRestUrl + "/" + theBugId, Bugs.class);

		logger.info("in getBugsById(): theBugs=" + theBugs);

		return theBugs;
	}

	@Override
	public void saveTicket(TicketRise theTicketRise) {

		logger.info("in saveTicket(): Calling REST API " + btsRestUrl);

		int ticketId = theTicketRise.getTicketId();

		// make REST call
		if (ticketId == 0) {
			// add employee
			restTemplate.postForEntity(btsRestUrl, theTicketRise, String.class);

		}
		logger.info("in saveTicket(): success");
	}

	public void updateTicket(TicketResolve ticketResolve) {
		restTemplate.put(btsRestUrl, ticketResolve);
	}

	@Override
	public void deleteTicket(int theId) {

		logger.info("in deleteCustomer(): Calling REST API " + btsRestUrl);

		// make REST call
		System.out.println(theId);
		restTemplate.delete(btsRestUrl + "/" + theId);

		logger.info("in deleteCustomer(): deleted customer theId=" + theId);
	}

}
