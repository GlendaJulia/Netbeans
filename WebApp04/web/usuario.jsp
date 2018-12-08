<%--validacion de sesion--%>
<%
HttpSession misession= (HttpSession) request.getSession();
  String usuario= (String) misession.getAttribute("usuario");
  String estado= (String) misession.getAttribute("estado");
  String glen ="";
  if(estado.equals("A")){
      glen ="Activo";
  }else if (estado.equals("X")){
      glen = "Inactivo";
  }else{
      glen = "No tiene estado";
  }
  
if(misession == null){
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a href='/WebApp04/index.html'>Loguearse</a>");
      return;
  }
  if(misession.getAttribute("usuario") == null){
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a href='/WebApp04/index.html'>Loguearse</a>");
      return;
  }    
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h3>Usuario Logeado: <b><% out.print(usuario); %></b></h3>
        <h4>Estado: <b><% out.print(glen); %></b></h4>
        <a href="/WebApp04/areas.jsp" target="_blank">Ir a Areas</a>
        <br><br><br>
        <a href="/WebApp04/cargos.jsp" target="_blank">Ir a Cargos</a>
        <h3><a href="/WebApp04/ServletSesion">Cerrar Sesion</a></h3>
    </body>
</html>