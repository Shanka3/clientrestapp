package com.slk.springrestclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.slk.springrestclient.exception.BugTrackingErrorResponse;
import com.slk.springrestclient.model.Bugs;
import com.slk.springrestclient.model.TicketResolve;
import com.slk.springrestclient.model.TicketRise;
import com.slk.springrestclient.service.BugService;

@Controller
@RequestMapping("/ticketrise")
public class BugController {

	// need to inject our customer service
	@Autowired
	private BugService bugService;

	@Autowired
	private BugTrackingErrorResponse bugTrackingErrorResponse;

	@GetMapping("/list")
	public String listBugs(Model theModel) {

		// get customers from the service
		List<Bugs> theBugs = bugService.getBugs();

		// add the customers to the model
		theModel.addAttribute("bugs", theBugs);
		System.out.println(theBugs);
		if (theBugs.isEmpty())
			return bugTrackingErrorResponse.handleBugDoesNotExistsException(theModel);

		else

			return "list-bugs";

	}

	@GetMapping("/getTicketId")
	public String getBugs(@RequestParam("theBugId") int theBugId, Model theModel) {

		// get customers from the service
		Bugs theBugs = bugService.getBugsById(theBugId);

		// add the customers to the model
		theModel.addAttribute("bugsId", theBugs);
		if (theBugs == null || theBugs.getBugId() == 0)
			return bugTrackingErrorResponse.handleBugIdDoesNotExistsException(theBugId, theModel);
		else

			return "get-bug-by-id";

	}

	@GetMapping("/showFormToCreateTicket")
	public String showFormToCreateTicket(Model theModel) {

		// create model attribute to bind form data
		TicketRise theTicketRise = new TicketRise();

		theModel.addAttribute("ticketRise", theTicketRise);

		return "ticketrise-form";
	}

	@PostMapping("/saveTicket")
	public String saveTicket( @ModelAttribute("ticketRise") TicketRise theTicketRise, Model model) {

		// save the customer using our service
		String moduleTye = theTicketRise.getBugModuleType().toLowerCase().replaceAll("\\s", "");
		if (moduleTye.equals("frontenddeveloper") || moduleTye.equals("backenddeveloper")
				|| moduleTye.equals("databasedeveloper")) {
			bugService.saveTicket(theTicketRise);
			return "redirect:/ticketrise/list";

		} else {

			return bugTrackingErrorResponse.handleTicketRiseException(model);
		}

	}

	@GetMapping("/showFormToUpdateTicket")
	public String showFormToUpdateTicket(Model theModel) {

		TicketResolve theTicketResolve = new TicketResolve();

		theModel.addAttribute("ticketResolve", theTicketResolve);
		return "updateticket-form";
	}

	@PostMapping("/updateTicket")
	public String updateTicket(@ModelAttribute("ticketResolve") TicketResolve theTicketResolve, Model model) {

		// save the customer using our service
		// BugTracker bugTracker =
		// bugTrackingDaoImpl.getSession().find(BugTracker.class, resolve.getBugId());

		Bugs theBugs = bugService.getBugsById(theTicketResolve.getBugId());

		if (bugService.getBugsById(theTicketResolve.getBugId()) == null)
			return bugTrackingErrorResponse.handleBugIdDoesNotExistsException(theTicketResolve.getBugId(), model);
		else if (theTicketResolve.getDevId() != theBugs.getAssignedTo())
			return bugTrackingErrorResponse.handelDeveloperIdDesnotFoundException(theTicketResolve.getDevId(), model);
		else {
			bugService.updateTicket(theTicketResolve);

			return "redirect:/ticketrise/list";
		}
	}

	@GetMapping("/showFormToDeleteTicket")
	public String showFormToDeleteTicket(Model theModel) {

		TicketResolve theTicketResolve = new TicketResolve();

		theModel.addAttribute("theTicketResolve", theTicketResolve);

		return "deleteticket-form";
	}

	@PostMapping("/deleteTicket")
	public String deleteTicket(@ModelAttribute("theTicketResolve") TicketResolve theTicketResolve, Model model) {

		// delete the customer
		if (bugService.getBugsById(theTicketResolve.getBugId()) == null)
			return bugTrackingErrorResponse.handleBugIdDoesNotExistsException(theTicketResolve.getBugId(), model);
		else if (!bugService.getBugsById(theTicketResolve.getBugId()).getStatus().toLowerCase().equals("complete"))
			return bugTrackingErrorResponse.handelBugStatusNotMatchException(theTicketResolve, model);
		else {
			bugService.deleteTicket(theTicketResolve.getBugId());

			return "redirect:/ticketrise/list";
		}
	}

}
