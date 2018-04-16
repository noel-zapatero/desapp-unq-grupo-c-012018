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

      out.write("<html style=\"background-color:grey\">\n");
      out.write("<meta charset=\"UTF-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<head>\n");
      out.write("  <style>\n");
      out.write("    * {\n");
      out.write("      box-sizing: border-box;\n");
      out.write("    }\n");
      out.write("    .menu {\n");
      out.write("      float:left;\n");
      out.write("      width:20%;\n");
      out.write("      text-align:center;\n");
      out.write("    }\n");
      out.write("    .menu a {\n");
      out.write("      background-color:#c90e0e;\n");
      out.write("      padding:8px;\n");
      out.write("      margin-top:7px;\n");
      out.write("      display:block;\n");
      out.write("      width:100%;\n");
      out.write("      color:black;\n");
      out.write("    }\n");
      out.write("    .main {\n");
      out.write("      float:left;\n");
      out.write("      width:60%;\n");
      out.write("      padding:0 20px;\n");
      out.write("    }\n");
      out.write("    .right {\n");
      out.write("      background-color:#c90e0e;\n");
      out.write("      float:left;\n");
      out.write("      width:20%;\n");
      out.write("      padding:15px;\n");
      out.write("      margin-top:7px;\n");
      out.write("      text-align:center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    @media only screen and (max-width:620px) {\n");
      out.write("      /* For mobile phones: */\n");
      out.write("      .menu, .main, .right {\n");
      out.write("        width:100%;\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <div style=\"background-color:#c90e0e;padding:15px;text-align:center;\">\n");
      out.write("    <img src=\"/logo/Logo%20Carpnd.png\" style=\"height: auto;max-width: 100%\">\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div style=\"overflow:auto\">\n");
      out.write("    <div class=\"menu\">\n");
      out.write("      <a href=\"#\">Load New Vehicle</a>\n");
      out.write("      <a href=\"#\">Make Publication</a>\n");
      out.write("      <a href=\"#\">My Vehicles</a>\n");
      out.write("      <a href=\"#\">My Rents</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"main\">\n");
      out.write("      <h2>(Vehiculo)</h2>\n");
      out.write("      <p>Foto del Vehiculo</p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"right\">\n");
      out.write("      <h2>Search</h2>\n");
      out.write("      <p>Mapa</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div style=\"background-color:#c90e0e;text-align:center;padding:10px;margin-top:7px;\">Â©Copyright - CARPND-GRUPO C</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
