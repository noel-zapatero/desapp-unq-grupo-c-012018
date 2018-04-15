package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html style=\"background-color:grey\">\r\n");
      out.write("<meta charset=\"UTF-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<head>\r\n");
      out.write("  <style>\r\n");
      out.write("    * {\r\n");
      out.write("      box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("    .menu {\r\n");
      out.write("      float:left;\r\n");
      out.write("      width:20%;\r\n");
      out.write("      text-align:center;\r\n");
      out.write("    }\r\n");
      out.write("    .menu a {\r\n");
      out.write("      background-color:#c90e0e;\r\n");
      out.write("      padding:8px;\r\n");
      out.write("      margin-top:7px;\r\n");
      out.write("      display:block;\r\n");
      out.write("      width:100%;\r\n");
      out.write("      color:black;\r\n");
      out.write("    }\r\n");
      out.write("    .main {\r\n");
      out.write("      float:left;\r\n");
      out.write("      width:60%;\r\n");
      out.write("      padding:0 20px;\r\n");
      out.write("    }\r\n");
      out.write("    .right {\r\n");
      out.write("      background-color:#c90e0e;\r\n");
      out.write("      float:left;\r\n");
      out.write("      width:20%;\r\n");
      out.write("      padding:15px;\r\n");
      out.write("      margin-top:7px;\r\n");
      out.write("      text-align:center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    @media only screen and (max-width:620px) {\r\n");
      out.write("      /* For mobile phones: */\r\n");
      out.write("      .menu, .main, .right {\r\n");
      out.write("        width:100%;\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  <div style=\"background-color:#c90e0e;padding:15px;text-align:center;\">\r\n");
      out.write("    <img src=\"/logo/Logo%20Carpnd.png\" style=\"height: auto;max-width: 100%\">\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <div style=\"overflow:auto\">\r\n");
      out.write("    <div class=\"menu\">\r\n");
      out.write("      <a href=\"#\">Load New Vehicle</a>\r\n");
      out.write("      <a href=\"#\">Make Publication</a>\r\n");
      out.write("      <a href=\"#\">My Vehicles</a>\r\n");
      out.write("      <a href=\"#\">My Rents</a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"main\">\r\n");
      out.write("      <h2>(Vehiculo)</h2>\r\n");
      out.write("      <p>Foto del Vehiculo</p>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"right\">\r\n");
      out.write("      <h2>Search</h2>\r\n");
      out.write("      <p>Mapa</p>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <div style=\"background-color:#c90e0e;text-align:center;padding:10px;margin-top:7px;\">Â©Copyright - CARPND-GRUPO C</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
