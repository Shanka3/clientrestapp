package com.slk.springrestclient.model;

public class Bugs {

	private int bugId;

	private int ticketId;

	private String bugName;

	private String bugDescription;

	private int assignedTo;

	private String status;

	private String bugModuleType;

	public Bugs() {

	}

	public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBugModuleType() {
		return bugModuleType;
	}

	public void setBugModuleType(String bugModuleType) {
		this.bugModuleType = bugModuleType;
	}

	@Override
	public String toString() {
		return "Bugs [bugId=" + bugId + ", ticketId=" + ticketId + ", bugName=" + bugName + ", bugDescription="
				+ bugDescription + ", assignedTo=" + assignedTo + ", status=" + status + ", bugModuleType="
				+ bugModuleType + "]";
	}

}
