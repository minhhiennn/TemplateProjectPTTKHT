/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-04-10 03:34:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<title>Home Page</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- Preloader -->\r\n");
      out.write("\t<div id=\"preloader\">\r\n");
      out.write("\t\t<div class=\"spinner\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- ##### Hero Area Start ##### -->\r\n");
      out.write("\t<section class=\"hero-area bg-img bg-overlay-2by5\"\r\n");
      out.write("\t\tstyle=\"background-image: url(/DoAnHTTT/template/img/bg-img/bg1.jpg);\">\r\n");
      out.write("\t\t<div class=\"container h-100\">\r\n");
      out.write("\t\t\t<div class=\"row h-100 align-items-center\">\r\n");
      out.write("\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t<!-- Hero Content -->\r\n");
      out.write("\t\t\t\t\t<div class=\"hero-content text-center\">\r\n");
      out.write("\t\t\t\t\t\t<h2>Let's Study Together</h2>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"btn clever-btn\">Get Started</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- ##### Hero Area End ##### -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- ##### Cool Facts Area Start ##### -->\r\n");
      out.write("\t<section class=\"cool-facts-area section-padding-100-0\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<!-- Single Cool Facts Area -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-sm-6 col-lg-3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-cool-facts-area text-center mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"250ms\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"icon\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/core-img/docs.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"counter\">1912</span>\r\n");
      out.write("\t\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t\t\t<h5>Success Stories</h5>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Single Cool Facts Area -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-sm-6 col-lg-3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-cool-facts-area text-center mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"500ms\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"icon\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/core-img/star.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"counter\">123</span>\r\n");
      out.write("\t\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t\t\t<h5>Dedicated Tutors</h5>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Single Cool Facts Area -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-sm-6 col-lg-3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-cool-facts-area text-center mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"750ms\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"icon\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/core-img/events.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"counter\">89</span>\r\n");
      out.write("\t\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t\t\t<h5>Scheduled Events</h5>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Single Cool Facts Area -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-sm-6 col-lg-3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-cool-facts-area text-center mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"1000ms\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"icon\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/core-img/earth.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"counter\">56</span>\r\n");
      out.write("\t\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t\t\t<h5>Available Courses</h5>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- ##### Cool Facts Area End ##### -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- ##### Popular Courses Start ##### -->\r\n");
      out.write("\t<section class=\"popular-courses-area section-padding-100-0\"\r\n");
      out.write("\t\tstyle=\"background-image: url(/DoAnHTTT/template/img/core-img/texture.png);\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"section-heading\">\r\n");
      out.write("\t\t\t\t\t\t<h3>Popular Online Courses</h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<!-- Single Popular Course -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-popular-course mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"250ms\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/c1.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t<!-- Course Content -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"course-content\">\r\n");
      out.write("\t\t\t\t\t\t\t<h4>English Grammar</h4>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"meta d-flex align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">Sarah Parker</a> <span><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-circle\" aria-hidden=\"true\"></i></span> <a href=\"#\">Art\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&amp; Design</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\tFusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- Seat Rating Fee -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"seat\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"rating\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"course-fee h-100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\" class=\"free\">Free</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Single Popular Course -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-popular-course mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"500ms\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/c2.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t<!-- Course Content -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"course-content\">\r\n");
      out.write("\t\t\t\t\t\t\t<h4>Vocabulary</h4>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"meta d-flex align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">Sarah Parker</a> <span><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-circle\" aria-hidden=\"true\"></i></span> <a href=\"#\">Art\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&amp; Design</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\tFusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- Seat Rating Fee -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"seat\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"rating\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"course-fee h-100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">$20</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Single Popular Course -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-popular-course mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"750ms\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/c3.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t<!-- Course Content -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"course-content\">\r\n");
      out.write("\t\t\t\t\t\t\t<h4>Expository writing</h4>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"meta d-flex align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">Sarah Parker</a> <span><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-circle\" aria-hidden=\"true\"></i></span> <a href=\"#\">Art\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&amp; Design</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\tFusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- Seat Rating Fee -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"seat\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"rating\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"course-fee h-100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">$45</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- ##### Popular Courses End ##### -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- ##### Best Tutors Start ##### -->\r\n");
      out.write("\t<section class=\"best-tutors-area section-padding-100\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"section-heading\">\r\n");
      out.write("\t\t\t\t\t\t<h3>The Best Tutors in Town</h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"tutors-slide owl-carousel wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"250ms\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- Single Tutors Slide -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"single-tutors-slides\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Thumbnail -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-thumbnail\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/t1.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Information -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-information text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5>Alex Parker</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Teacher</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\t\tMorbi fermentum laoreet elit, sit amet tincidunt mauris\r\n");
      out.write("\t\t\t\t\t\t\t\t\tultrices vitae.</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"social-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- Single Tutors Slide -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"single-tutors-slides\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Thumbnail -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-thumbnail\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/t2.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Information -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-information text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5>Alex Parker</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Teacher</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\t\tMorbi fermentum laoreet elit, sit amet tincidunt mauris\r\n");
      out.write("\t\t\t\t\t\t\t\t\tultrices vitae.</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"social-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- Single Tutors Slide -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"single-tutors-slides\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Thumbnail -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-thumbnail\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/t3.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Information -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-information text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5>Alex Parker</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Teacher</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\t\tMorbi fermentum laoreet elit, sit amet tincidunt mauris\r\n");
      out.write("\t\t\t\t\t\t\t\t\tultrices vitae.</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"social-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- Single Tutors Slide -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"single-tutors-slides\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Thumbnail -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-thumbnail\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/t4.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Information -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-information text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5>Alex Parker</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Teacher</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\t\tMorbi fermentum laoreet elit, sit amet tincidunt mauris\r\n");
      out.write("\t\t\t\t\t\t\t\t\tultrices vitae.</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"social-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- Single Tutors Slide -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"single-tutors-slides\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Thumbnail -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-thumbnail\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/t5.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Tutor Information -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tutor-information text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5>Alex Parker</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Teacher</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\t\tMorbi fermentum laoreet elit, sit amet tincidunt mauris\r\n");
      out.write("\t\t\t\t\t\t\t\t\tultrices vitae.</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"social-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- ##### Best Tutors End ##### -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- ##### Register Now Start ##### -->\r\n");
      out.write("\t<section\r\n");
      out.write("\t\tclass=\"register-now section-padding-100-0 d-flex justify-content-between align-items-center\"\r\n");
      out.write("\t\tstyle=\"background-image: url(/DoAnHTTT/template/img/core-img/texture.png);\">\r\n");
      out.write("\t\t<!-- Register Contact Form -->\r\n");
      out.write("\t\t<div class=\"register-contact-form mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\tdata-wow-delay=\"250ms\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"forms\">\r\n");
      out.write("\t\t\t\t\t\t\t<h4>Courses For Free</h4>\r\n");
      out.write("\t\t\t\t\t\t\t<form action=\"#\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-12 col-lg-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"Name\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-12 col-lg-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"email\" class=\"form-control\" id=\"email\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"Email\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-12 col-lg-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"phone\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"Phone\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-12 col-lg-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"site\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"Site\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button class=\"btn clever-btn w-100\">Send Message</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Register Now Countdown -->\r\n");
      out.write("\t\t<div class=\"register-now-countdown mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\tdata-wow-delay=\"500ms\">\r\n");
      out.write("\t\t\t<h3>Register Now</h3>\r\n");
      out.write("\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi\r\n");
      out.write("\t\t\t\tfermentum laoreet elit, sit amet tincidunt mauris ultrices vitae.\r\n");
      out.write("\t\t\t\tDonec bibendum tortor sed mi faucibus vehicula. Sed erat lorem</p>\r\n");
      out.write("\t\t\t<!-- Register Countdown -->\r\n");
      out.write("\t\t\t<div class=\"register-countdown\">\r\n");
      out.write("\t\t\t\t<div class=\"events-cd d-flex flex-wrap\" data-countdown=\"2019/03/01\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- ##### Register Now End ##### -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- ##### Upcoming Events Start ##### -->\r\n");
      out.write("\t<section class=\"upcoming-events section-padding-100-0\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"section-heading\">\r\n");
      out.write("\t\t\t\t\t\t<h3>Upcoming events</h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<!-- Single Upcoming Events -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-upcoming-events mb-50 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"250ms\">\r\n");
      out.write("\t\t\t\t\t\t<!-- Events Thumb -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"events-thumb\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/e1.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t<h6 class=\"event-date\">August 26</h6>\r\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"event-title\">Networking Day</h4>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- Date & Fee -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"date-fee d-flex justify-content-between\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"date\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-clock\"></i> August 26 @ 9:00 am\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"events-fee\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">$45</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Single Upcoming Events -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-upcoming-events mb-50 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"500ms\">\r\n");
      out.write("\t\t\t\t\t\t<!-- Events Thumb -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"events-thumb\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/e2.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t<h6 class=\"event-date\">August 7</h6>\r\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"event-title\">Open Doors Day</h4>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- Date & Fee -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"date-fee d-flex justify-content-between\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"date\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-clock\"></i> August 7 @ 9:00 am\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"events-fee\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\" class=\"free\">Free</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Single Upcoming Events -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-upcoming-events mb-50 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"750ms\">\r\n");
      out.write("\t\t\t\t\t\t<!-- Events Thumb -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"events-thumb\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/bg-img/e3.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t<h6 class=\"event-date\">August 3</h6>\r\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"event-title\">Creative Leadership</h4>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- Date & Fee -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"date-fee d-flex justify-content-between\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"date\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-clock\"></i> August 3 @ 9:00 am\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"events-fee\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">$45</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- ##### Upcoming Events End ##### -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- ##### Blog Area Start ##### -->\r\n");
      out.write("\t<section class=\"blog-area section-padding-100-0\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"section-heading\">\r\n");
      out.write("\t\t\t\t\t\t<h3>From Our Blog</h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<!-- Single Blog Area -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-md-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-blog-area mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"250ms\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/blog-img/1.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t<!-- Blog Content -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"blog-content\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"blog-headline\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h4>English Grammer</h4>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"meta d-flex align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">Sarah Parker</a> <span><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-circle\" aria-hidden=\"true\"></i></span> <a href=\"#\">Art\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&amp; Design</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\tFusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Single Blog Area -->\r\n");
      out.write("\t\t\t\t<div class=\"col-12 col-md-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-blog-area mb-100 wow fadeInUp\"\r\n");
      out.write("\t\t\t\t\t\tdata-wow-delay=\"500ms\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/DoAnHTTT/template/img/blog-img/2.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t<!-- Blog Content -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"blog-content\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"blog-headline\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h4>English Grammer</h4>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"meta d-flex align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">Sarah Parker</a> <span><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-circle\" aria-hidden=\"true\"></i></span> <a href=\"#\">Art\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&amp; Design</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("\t\t\t\t\t\t\t\tFusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- ##### Blog Area End ##### -->\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
