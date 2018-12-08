package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class Oracle_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url    = "jdbc:oracle:thin:@localhost:1521:XE";
  String user   = "usr_Merma";
  String pass   = "DSISTecsup2";
  
  Class.forName(driver);
  Connection xcon = DriverManager.getConnection(url, user, pass);
  
  String sql = "select * from usr_Merma";
  Statement stm = xcon.createStatement();
  ResultSet rs = stm.executeQuery(sql);

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("      .table-striped>tbody>tr:nth-child(odd)>td, \n");
      out.write("      .table-striped>tbody>tr:nth-child(odd)>th {\n");
      out.write("       background-color: #ff0;\n");
      out.write("      }\n");
      out.write("      .table-striped>tbody>tr:nth-child(even)>td, \n");
      out.write("      .table-striped>tbody>tr:nth-child(even)>th {\n");
      out.write("       background-color: #ccc;\n");
      out.write("      }\n");
      out.write("      .table-striped>thead>tr>th {\n");
      out.write("         background-color: #eee;\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Listado de Tabla Areas</h2>\n");
      out.write("        <table border=\"1\" class=\"table table-striped\">\n");
      out.write("        <tr>\n");
      out.write("            <td style='text-align:center;width:100px;font-weight: bold;'>COD</td>\n");
      out.write("            <td style='text-align:center;width:250px;font-weight: bold;'>NOMBRE</td>\n");
      out.write("            <td style='text-align:center;width:100px;font-weight: bold;'>ESTADO</td></tr>\n");
      out.write("        ");

        while( rs.next() ) {
           out.print("<tr>");
           out.print("<td>"+rs.getString(1)+"</td>");
           out.print("<td>"+rs.getString(2)+"</td>");
           out.print("<td>"+rs.getString(3)+"</td>");
           out.print("</tr>");
        }    
       
      out.write("\n");
      out.write("       </table>\n");
      out.write("    </body>\n");
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
