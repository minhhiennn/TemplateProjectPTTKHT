/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-04-10 03:30:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class courses_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <!-- Preloader -->\r\n");
      out.write("    <div id=\"preloader\">\r\n");
      out.write("        <div class=\"spinner\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- ##### Header Area Start ##### -->\r\n");
      out.write("    <!-- ##### Header Area End ##### -->\r\n");
      out.write("\r\n");
      out.write("    <!-- ##### Breadcumb Area Start ##### -->\r\n");
      out.write("    <div class=\"breadcumb-area\">\r\n");
      out.write("        <!-- Breadcumb -->\r\n");
      out.write("        <nav aria-label=\"breadcrumb\">\r\n");
      out.write("            <ol class=\"breadcrumb\">\r\n");
      out.write("                <li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\r\n");
      out.write("                <li class=\"breadcrumb-item\"><a href=\"#\">Courses</a></li>\r\n");
      out.write("                <li class=\"breadcrumb-item active\" aria-current=\"page\">Art &amp; Design</li>\r\n");
      out.write("            </ol>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- ##### Breadcumb Area End ##### -->\r\n");
      out.write("\r\n");
      out.write("    <!-- ##### Catagory ##### -->\r\n");
      out.write("    <div class=\"clever-catagory bg-img d-flex align-items-center justify-content-center p-3\" style=\"background-image: url(img/bg-img/bg2.jpg);\">\r\n");
      out.write("        <h3>Art &amp; Design</h3>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- ##### Popular Course Area Start ##### -->\r\n");
      out.write("    <section class=\"popular-courses-area section-padding-100\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <!-- Single Popular Course -->\r\n");
      out.write("                <div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("                    <div class=\"single-popular-course mb-100 wow fadeInUp\" data-wow-delay=\"250ms\">\r\n");
      out.write("                        <img src=\"/spring-mvc/template/img/bg-img/c1.jpg\" alt=\"\">\r\n");
      out.write("                        <!-- Course Content -->\r\n");
      out.write("                        <div class=\"course-content\">\r\n");
      out.write("                            <h4>English Grammar</h4>\r\n");
      out.write("                            <div class=\"meta d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\">Sarah Parker</a>\r\n");
      out.write("                                <span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                                <a href=\"#\">Art &amp; Design</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Seat Rating Fee -->\r\n");
      out.write("                        <div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("                            <div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("                                <div class=\"seat\">\r\n");
      out.write("                                    <i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"rating\">\r\n");
      out.write("                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"course-fee h-100\">\r\n");
      out.write("                                <a href=\"#\" class=\"free\">Free</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Single Popular Course -->\r\n");
      out.write("                <div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("                    <div class=\"single-popular-course mb-100 wow fadeInUp\" data-wow-delay=\"500ms\">\r\n");
      out.write("                        <img src=\"/spring-mvc/template/img/bg-img/c2.jpg\" alt=\"\">\r\n");
      out.write("                        <!-- Course Content -->\r\n");
      out.write("                        <div class=\"course-content\">\r\n");
      out.write("                            <h4>Vocabulary</h4>\r\n");
      out.write("                            <div class=\"meta d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\">Sarah Parker</a>\r\n");
      out.write("                                <span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                                <a href=\"#\">Art &amp; Design</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Seat Rating Fee -->\r\n");
      out.write("                        <div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("                            <div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("                                <div class=\"seat\">\r\n");
      out.write("                                    <i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"rating\">\r\n");
      out.write("                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"course-fee h-100\">\r\n");
      out.write("                                <a href=\"#\">$20</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Single Popular Course -->\r\n");
      out.write("                <div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("                    <div class=\"single-popular-course mb-100 wow fadeInUp\" data-wow-delay=\"750ms\">\r\n");
      out.write("                        <img src=\"/spring-mvc/template/img/bg-img/c3.jpg\" alt=\"\">\r\n");
      out.write("                        <!-- Course Content -->\r\n");
      out.write("                        <div class=\"course-content\">\r\n");
      out.write("                            <h4>Expository writing</h4>\r\n");
      out.write("                            <div class=\"meta d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\">Sarah Parker</a>\r\n");
      out.write("                                <span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                                <a href=\"#\">Art &amp; Design</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Seat Rating Fee -->\r\n");
      out.write("                        <div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("                            <div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("                                <div class=\"seat\">\r\n");
      out.write("                                    <i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"rating\">\r\n");
      out.write("                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"course-fee h-100\">\r\n");
      out.write("                                <a href=\"#\">$45</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Single Popular Course -->\r\n");
      out.write("                <div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("                    <div class=\"single-popular-course mb-100 wow fadeInUp\" data-wow-delay=\"250ms\">\r\n");
      out.write("                        <img src=\"/spring-mvc/template/img/bg-img/c4.jpg\" alt=\"\">\r\n");
      out.write("                        <!-- Course Content -->\r\n");
      out.write("                        <div class=\"course-content\">\r\n");
      out.write("                            <h4>Vocabulary</h4>\r\n");
      out.write("                            <div class=\"meta d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\">Sarah Parker</a>\r\n");
      out.write("                                <span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                                <a href=\"#\">Art &amp; Design</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Seat Rating Fee -->\r\n");
      out.write("                        <div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("                            <div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("                                <div class=\"seat\">\r\n");
      out.write("                                    <i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"rating\">\r\n");
      out.write("                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"course-fee h-100\">\r\n");
      out.write("                                <a href=\"#\">$45</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Single Popular Course -->\r\n");
      out.write("                <div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("                    <div class=\"single-popular-course mb-100 wow fadeInUp\" data-wow-delay=\"500ms\">\r\n");
      out.write("                        <img src=\"/spring-mvc/template/img/bg-img/c5.jpg\" alt=\"\">\r\n");
      out.write("                        <!-- Course Content -->\r\n");
      out.write("                        <div class=\"course-content\">\r\n");
      out.write("                            <h4>English Grammer</h4>\r\n");
      out.write("                            <div class=\"meta d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\">Sarah Parker</a>\r\n");
      out.write("                                <span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                                <a href=\"#\">Art &amp; Design</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Seat Rating Fee -->\r\n");
      out.write("                        <div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("                            <div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("                                <div class=\"seat\">\r\n");
      out.write("                                    <i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"rating\">\r\n");
      out.write("                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"course-fee h-100\">\r\n");
      out.write("                                <a href=\"#\" class=\"free\">Free</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Single Popular Course -->\r\n");
      out.write("                <div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("                    <div class=\"single-popular-course mb-100 wow fadeInUp\" data-wow-delay=\"750ms\">\r\n");
      out.write("                        <img src=\"/spring-mvc/template/img/bg-img/c6.jpg\" alt=\"\">\r\n");
      out.write("                        <!-- Course Content -->\r\n");
      out.write("                        <div class=\"course-content\">\r\n");
      out.write("                            <h4>Expository writing</h4>\r\n");
      out.write("                            <div class=\"meta d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\">Sarah Parker</a>\r\n");
      out.write("                                <span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                                <a href=\"#\">Art &amp; Design</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Seat Rating Fee -->\r\n");
      out.write("                        <div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("                            <div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("                                <div class=\"seat\">\r\n");
      out.write("                                    <i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"rating\">\r\n");
      out.write("                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"course-fee h-100\">\r\n");
      out.write("                                <a href=\"#\">$45</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Single Popular Course -->\r\n");
      out.write("                <div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("                    <div class=\"single-popular-course mb-100 wow fadeInUp\" data-wow-delay=\"250ms\">\r\n");
      out.write("                        <img src=\"/spring-mvc/template/img/bg-img/c7.jpg\" alt=\"\">\r\n");
      out.write("                        <!-- Course Content -->\r\n");
      out.write("                        <div class=\"course-content\">\r\n");
      out.write("                            <h4>English Grammer</h4>\r\n");
      out.write("                            <div class=\"meta d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\">Sarah Parker</a>\r\n");
      out.write("                                <span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                                <a href=\"#\">Art &amp; Design</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Seat Rating Fee -->\r\n");
      out.write("                        <div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("                            <div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("                                <div class=\"seat\">\r\n");
      out.write("                                    <i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"rating\">\r\n");
      out.write("                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"course-fee h-100\">\r\n");
      out.write("                                <a href=\"#\" class=\"free\">Free</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Single Popular Course -->\r\n");
      out.write("                <div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("                    <div class=\"single-popular-course mb-100 wow fadeInUp\" data-wow-delay=\"500ms\">\r\n");
      out.write("                        <img src=\"/spring-mvc/template/img/bg-img/c8.jpg\" alt=\"\">\r\n");
      out.write("                        <!-- Course Content -->\r\n");
      out.write("                        <div class=\"course-content\">\r\n");
      out.write("                            <h4>Vocabulary</h4>\r\n");
      out.write("                            <div class=\"meta d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\">Sarah Parker</a>\r\n");
      out.write("                                <span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                                <a href=\"#\">Art &amp; Design</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Seat Rating Fee -->\r\n");
      out.write("                        <div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("                            <div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("                                <div class=\"seat\">\r\n");
      out.write("                                    <i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"rating\">\r\n");
      out.write("                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"course-fee h-100\">\r\n");
      out.write("                                <a href=\"#\">$20</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Single Popular Course -->\r\n");
      out.write("                <div class=\"col-12 col-md-6 col-lg-4\">\r\n");
      out.write("                    <div class=\"single-popular-course mb-100 wow fadeInUp\" data-wow-delay=\"750ms\">\r\n");
      out.write("                        <img src=\"/spring-mvc/template/img/bg-img/c9.jpg\" alt=\"\">\r\n");
      out.write("                        <!-- Course Content -->\r\n");
      out.write("                        <div class=\"course-content\">\r\n");
      out.write("                            <h4>Expository writing</h4>\r\n");
      out.write("                            <div class=\"meta d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\">Sarah Parker</a>\r\n");
      out.write("                                <span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                                <a href=\"#\">Art &amp; Design</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Seat Rating Fee -->\r\n");
      out.write("                        <div class=\"seat-rating-fee d-flex justify-content-between\">\r\n");
      out.write("                            <div class=\"seat-rating h-100 d-flex align-items-center\">\r\n");
      out.write("                                <div class=\"seat\">\r\n");
      out.write("                                    <i class=\"fa fa-user\" aria-hidden=\"true\"></i> 10\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"rating\">\r\n");
      out.write("                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i> 4.5\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"course-fee h-100\">\r\n");
      out.write("                                <a href=\"#\">$45</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <div class=\"load-more text-center wow fadeInUp\" data-wow-delay=\"1000ms\">\r\n");
      out.write("                        <a href=\"#\" class=\"btn clever-btn btn-2\">Load More</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
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