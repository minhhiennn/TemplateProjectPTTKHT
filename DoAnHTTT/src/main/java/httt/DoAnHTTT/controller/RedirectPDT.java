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
}
