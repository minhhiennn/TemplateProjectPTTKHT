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
	@RequestMapping(value = "/admin/DSMonHoc", method = RequestMethod.GET)
	public ModelAndView DSMonHoc() {
		ModelAndView mav = new ModelAndView("admin/DSMonHoc");
		return mav;
	}
	@RequestMapping(value = "/admin/DSHocSinh", method = RequestMethod.GET)
	public ModelAndView DSHocSinh() {
		ModelAndView mav = new ModelAndView("admin/DSHocSinh");
		return mav;
	}
	@RequestMapping(value = "/admin/DSHocSinh", method = RequestMethod.POST)
	public ModelAndView DSHocSinhPost() {
		ModelAndView mav = new ModelAndView("admin/DSHocSinh");
		return mav;
	}
}