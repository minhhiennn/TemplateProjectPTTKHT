package httt.DoAnHTTT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectPDT {
	
	@RequestMapping(value = "/pdt/index", method = RequestMethod.GET)
	public ModelAndView PDTHomeView() {
		ModelAndView mav = new ModelAndView("pdt/index");
		return mav;
	}
	@RequestMapping(value = "/pdt/table", method = RequestMethod.GET)
	public ModelAndView PDTTableView() {
		ModelAndView mav = new ModelAndView("pdt/table");
		return mav;
	}
	@RequestMapping(value = "/pdt/table", method = RequestMethod.POST)
	public ModelAndView PDTTableViewPost() {
		ModelAndView mav = new ModelAndView("pdt/table");
		return mav;
	}
	@RequestMapping(value = "/pdt/updateAndInsert", method = RequestMethod.GET)
	public ModelAndView PDTUpdateAndInsertView() {
		ModelAndView mav = new ModelAndView("pdt/updateAndInsert");
		return mav;
	}
	@RequestMapping(value = "/pdt/closeRegistration", method = RequestMethod.GET)
	public ModelAndView PDTcloseRegistrationView() {
		ModelAndView mav = new ModelAndView("pdt/closeRegistration");
		return mav;
	}
}
