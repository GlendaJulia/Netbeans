package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class areas_jsp extends org.apache.jasper.runtime.HttpJspBase
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

HttpSession misession= (HttpSession) request.getSession();
  String usuario= (String) misession.getAttribute("usuario");  
if(misession == null){
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a href='/LAb04/index.html'>Loguearse</a>");
      return;
  }
  if(misession.getAttribute("usuario") == null){
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a href='/LAb04/index.html'>Loguearse</a>");
      return;
  }    

      out.write('\n');
      out.write('\n');

  String driver = "com.mysql.cj.jdbc.Driver";
  String url    = "jdbc:mysql://localhost:3306/practica01?useSSL=false&serverTimezone=UTC";
  String user   = "root";
  String pass   = "DSISTecsup2";
  
  Class.forName(driver);
  Connection xcon = DriverManager.getConnection(url, user, pass);
  
  String sql = "SELECT U.Nombre_usuario, C.Nombre_curso, C.Nota_curso FROM cursos C, usuarios U WHERE U.codigo_usuario = C.Codigo_usuario";
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
      out.write("            body{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table#listado {\n");
      out.write("    background-color: #AAAAAA;\n");
      out.write("    color: #0000BB;\n");
      out.write("    font: 12px/14px Arial;\n");
      out.write("    border-style: solid;\n");
      out.write("    border-width:3px;\n");
      out.write("    border-color:black;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table#listado th {\n");
      out.write("    background-color: #333333;\n");
      out.write("    color: #FFFFFF;\n");
      out.write("    font: 15px/25px Arial;\n");
      out.write("    font-weight:bold;\n");
      out.write("    padding-left: 5px;\n");
      out.write("    padding-right: 5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table#listado td {\n");
      out.write("    background-color: #FFFFFF;\n");
      out.write("    color: #0000FF;\n");
      out.write("    font: 13px/16px Arial;\n");
      out.write("    padding: 2px;\n");
      out.write(" }\n");
      out.write(" table#editar {\n");
      out.write("    background-color: #BBBBBB;\n");
      out.write("    color: #0000BB;\n");
      out.write("    font: 12px/18px Arial;\n");
      out.write("    font-weight: bold;\n");
      out.write("    border-style: solid;\n");
      out.write("    border-width:3px;\n");
      out.write("    border-color:#000000;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table#editar th {\n");
      out.write("    background-color: #444444;\n");
      out.write("    color: #FFFFFF;\n");
      out.write("    font: 16px/25px Arial;\n");
      out.write("    font-weight:bolder;\n");
      out.write("    text-align: left;\n");
      out.write("    padding-left: 5px;\n");
      out.write("    padding-right: 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table#editar td {\n");
      out.write("    background-color: #FFFFFF;\n");
      out.write("    color: #0000BB;\n");
      out.write("    font: 12px/18px Arial;\n");
      out.write("    font-weight: bold;\n");
      out.write("    border-style: solid;\n");
      out.write("    border-width: 1px;\n");
      out.write("    border-color: #666666;\n");
      out.write("    padding:7px;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=green>\n");
      out.write("        \n");
      out.write("        <h3>Usuario Logeado: <b>");
 out.print(usuario); 
      out.write("</b></h3>\n");
      out.write("        <h3><a href=\"/LAb04/ServletSesion\">Cerrar Sesion</a></h3>\n");
      out.write("        <h2>Listado de Tabla Areas</h2>\n");
      out.write("        <table id=\"listado\">\n");
      out.write("        <tr>\n");
      out.write("            <td style='text-align:center;width:250px;font-weight: bold;'>NOMBRE</td>\n");
      out.write("            <td style='text-align:center;width:100px;font-weight: bold;'>CURSO</td>\n");
      out.write("            <td style='text-align:center;width:100px;font-weight: bold;'>NOTA</td></tr>\n");
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
      out.write("\n");
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
