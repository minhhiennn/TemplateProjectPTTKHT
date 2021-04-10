package httt.DoAnHTTT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Redirect {
	
	@RequestMapping(value = "/student/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("student/home");
		return mav;
	}
	@RequestMapping(value = "/student/blog", method = RequestMethod.GET)
	public ModelAndView blogPage() {
		ModelAndView mav = new ModelAndView("student/blog");
		return mav;
	}
	@RequestMapping(value = "/student/blog-details", method = RequestMethod.GET)
	public ModelAndView blogDetailsPage() {
		ModelAndView mav = new ModelAndView("student/blog-details");
		return mav;
	}
	@RequestMapping(value = "/student/contact", method = RequestMethod.GET)
	public ModelAndView contactPage() {
		ModelAndView mav = new ModelAndView("student/contact");
		return mav;
	}
	@RequestMapping(value = "/student/courses", method = RequestMethod.GET)
	public ModelAndView coursesPage() {
		ModelAndView mav = new ModelAndView("student/courses");
		return mav;
	}
	@RequestMapping(value = "/student/instructors", method = RequestMethod.GET)
	public ModelAndView instructorsPage() {
		ModelAndView mav = new ModelAndView("student/instructors");
		return mav;
	}
	@RequestMapping(value = "/student/regular-page", method = RequestMethod.GET)
	public ModelAndView regularPage() {
		ModelAndView mav = new ModelAndView("student/regular-page");
		return mav;
	}
	@RequestMapping(value = "/student/single-course", method = RequestMethod.GET)
	public ModelAndView singleCoursePage() {
		ModelAndView mav = new ModelAndView("student/single-course");
		return mav;
	}
	@RequestMapping(value = "/student/table", method = RequestMethod.GET)
	public ModelAndView tablePage() {
		ModelAndView mav = new ModelAndView("student/table");
		return mav;
	}	
}