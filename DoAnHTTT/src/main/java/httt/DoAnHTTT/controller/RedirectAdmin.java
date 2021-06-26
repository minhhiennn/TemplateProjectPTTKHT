package httt.DoAnHTTT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectAdmin {
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/index");
		return mav;
	}
	@RequestMapping(value = "/admin/addStudent", method = RequestMethod.GET)
	public ModelAndView layout_Static() {
		ModelAndView mav = new ModelAndView("admin/AddStudent");
		return mav;
	}
	@RequestMapping(value = "/admin/TKBProfessor", method = RequestMethod.GET)
	public ModelAndView TKB_Professor() {
		ModelAndView mav = new ModelAndView("admin/TKBProfessor");
		return mav;
	}
}