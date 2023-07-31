package com.slk.springrestclient.model;

import org.springframework.lang.NonNull;

public class TicketRise {

	private int ticketId;

	
	private String testerName;

	@NonNull
	private String bugName;

	@NonNull
	private String bugDescription;

	@NonNull
	private String bugModuleType;

	public TicketRise() {

	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTesterName() {
		return testerName;
	}

	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}

	public String getBugName() {
		return bugName;
	}

	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	public String getBugDescription() {
		return bugDescription;
	}

	public void setBugDescription(String bugDescription) {
		this.bugDescription = bugDescription;
	}

	public String getBugModuleType() {
		return bugModuleType;
	}

	public void setBugModuleType(String bugModuleType) {
		this.bugModuleType = bugModuleType;
	}

}
