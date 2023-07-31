package com.slk.springrestclient.service;

import java.util.List;

import com.slk.springrestclient.model.Bugs;
import com.slk.springrestclient.model.TicketResolve;
import com.slk.springrestclient.model.TicketRise;

public interface BugService {

	public List<Bugs> getBugs();

	public void saveTicket(TicketRise theTicketRise);

	public void updateTicket(TicketResolve theTicketResolve);

	public Bugs getBugsById(int theBugId);

	public void deleteTicket(int theId);

}
