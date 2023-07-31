package com.slk.springrestclient.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.slk.springrestclient.model.TicketResolve;
import com.slk.springrestclient.service.BugService;

@ControllerAdvice
public class BugTrackingErrorResponse {

	@Autowired
	private BugService bugService;

	public String handleBugDoesNotExistsException(Model model) {
		model.addAttribute("message", "Currently no bugs exists.");
		return "error-view";
	}

	public String handleBugIdDoesNotExistsException(int bugId, Model model) {
		model.addAttribute("message", "The bugid: " + bugId + " doesn't exists. Please chech with bugid.");
		return "error-view";
	}

	public String handleTicketRiseException(Model model) {
		model.addAttribute("message",
				"To rise a ticket please select the mentioned bug module type: 1.Frontend Developer, 2.Backend Developer, 3.Database Developer.");
		return "error-view";
	}

	public String handelDeveloperIdDesnotFoundException(int developerId, Model model) {
		model.addAttribute("message", "The develper with the ID: " + developerId
				+ " doesn't have a access to update the bug status, Please check with developer id.");
		return "error-view";
	}

	public String handelBugStatusNotMatchException(TicketResolve theTicketResolve, Model model) {
		model.addAttribute("message",
				"The bug id: " + theTicketResolve.getBugId() + " cannot be deleted because the status is still: "
						+ bugService.getBugsById(theTicketResolve.getBugId()).getStatus());
		return "error-view";
	}
}
