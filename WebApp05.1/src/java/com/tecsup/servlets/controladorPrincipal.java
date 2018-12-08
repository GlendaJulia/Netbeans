/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.servlets;

import com.tecsup.datos.cBaseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "controladorPrincipal", urlPatterns = {"/controladorPrincipal"})
public class controladorPrincipal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
       cBaseDatos objDatos = new cBaseDatos();
       String accion = request.getParameter("accion");
       if ( accion == null )
          accion = "bienvenida";
       if (accion.equals("bienvenida"))
          request.getRequestDispatcher( "/contenido.html" ).forward(request,response);
       else if (accion.equals("listadoAreas")) {
          Vector arrAreas = (Vector)objDatos.getAreas();
          request.setAttribute("arrAreas", arrAreas);
          request.getRequestDispatcher( "/mantenimientos/listadoAreas.jsp" ).forward( 
               request,response);
       }
       else if (accion.equals("listadoAlumnos")) {
          Vector arrAlumnos = (Vector)objDatos.getAlumnos();
          request.setAttribute("arrAlumnos", arrAlumnos);
          request.getRequestDispatcher( "/mantenimientos/listadoAlumnos.jsp" ).forward( 
               request,response);
       }
       else if (accion.equals("listadoCursos")) {
          Vector arrCursos = (Vector)objDatos.getCursos();
          request.setAttribute("arrCursos", arrCursos);
          request.getRequestDispatcher( "/mantenimientos/listadoCursos.jsp" ).forward( 
               request,response);
       }
       else if (accion.equals("listadoUsuarios")) {
          Vector arrUsuarios = (Vector)objDatos.getUsuarios();
          request.setAttribute("arrUsuarios", arrUsuarios);
          request.getRequestDispatcher( "/mantenimientos/listadoUsuarios.jsp" ).forward( 
               request,response);
       }
       else if (accion.equals("NuevoEliminarArea")) {
          if ( request.getParameter( "boton" ).compareTo( "Nuevo Registro") == 0 ) {
             Vector registro = new Vector();
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");

             request.setAttribute( "registro", registro );
             request.setAttribute( "operacion","INSERT");
             request.setAttribute( "titulo","Nueva Area");
             request.getRequestDispatcher( "/mantenimientos/editarAreas.jsp" ).forward( 
                request,response );
          }
          else {
         String[] datos = request.getParameterValues("xcod");
         objDatos.eliminarAreas(datos);
         request.getRequestDispatcher("/controladorPrincipal?accion=listadoAreas").forward(
            request,response );
        }
       }
       else if (accion.equals("NuevoEliminarAlumno")) {
          if ( request.getParameter( "boton" ).compareTo( "Nuevo Registro") == 0 ) {
             Vector registro = new Vector();
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");

             request.setAttribute( "registro", registro );
             request.setAttribute( "operacion","INSERT");
             request.setAttribute( "titulo","Nuevo Alumno");
             request.getRequestDispatcher( "/mantenimientos/editarAlumnos.jsp" ).forward( 
                request,response );
          }
          else {
         String[] datos = request.getParameterValues("xcod");
         objDatos.eliminarAlumnos(datos);
         request.getRequestDispatcher("/controladorPrincipal?accion=listadoAlumnos").forward(
            request,response );
        }
       }
       else if (accion.equals("NuevoEliminarCurso")) {
          if ( request.getParameter( "boton" ).compareTo( "Nuevo Registro") == 0 ) {
             Vector registro = new Vector();
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");
             
             request.setAttribute( "registro", registro );
             request.setAttribute( "operacion","INSERT");
             request.setAttribute( "titulo","Nuevo Curso");
             request.getRequestDispatcher( "/mantenimientos/editarCursos.jsp" ).forward( 
                request,response );
          }
          else {
         String[] datos = request.getParameterValues("xcod");
         objDatos.eliminarCursos(datos);
         request.getRequestDispatcher("/controladorPrincipal?accion=listadoCursos").forward(
            request,response );
        }
       }
       else if (accion.equals("NuevoEliminarUsuario")) {
          if ( request.getParameter( "boton" ).compareTo( "Nuevo Registro") == 0 ) {
             Vector registro = new Vector();
             registro.add("");
             registro.add("");
             registro.add("");
             registro.add("");

             request.setAttribute( "registro", registro );
             request.setAttribute( "operacion","INSERT");
             request.setAttribute( "titulo","Nuevo Usuario");
             request.getRequestDispatcher( "/mantenimientos/editarUsuarios.jsp" ).forward( 
                request,response );
          }
          else {
         String[] datos = request.getParameterValues("xcod");
         objDatos.eliminarUsuarios(datos);
         request.getRequestDispatcher("/controladorPrincipal?accion=listadoUsuarios").forward(
            request,response );
        }
       }
       else if ( accion.compareTo( "GRABAR_AREA") == 0 ) {
          if ( request.getParameter( "boton" ).compareTo( "GRABAR" ) == 0 ) {
             String operacion = request.getParameter("operacion");
             if ( operacion.equals("INSERT")) {
                String[] datos = new String[3];
                datos[0] = request.getParameter("xnom");
                datos[1] = request.getParameter("xabr");
                datos[2] = request.getParameter("xest");
                objDatos.grabarNuevaArea(datos);
            }else {
                 String[] datos = new String[4];
                 datos[0] = request.getParameter("xcod");
                 datos[1] = request.getParameter("xnom");
                 datos[2] = request.getParameter("xabr");
                 datos[3] = request.getParameter("xest");
                 objDatos.modificarArea(datos);
             }
         }
         request.getRequestDispatcher("/controladorPrincipal?accion=listadoAreas").forward(
            request,response );
     }
       else if ( accion.compareTo( "GRABAR_ALUMNO") == 0 ) {
          if ( request.getParameter( "boton" ).compareTo( "GRABAR" ) == 0 ) {
             String operacion = request.getParameter("operacion");
             if ( operacion.equals("INSERT")) {
                String[] datos = new String[8];
                datos[0] = request.getParameter("xnom");
                datos[1] = request.getParameter("xdir");
                datos[2] = request.getParameter("xema");
                datos[3] = request.getParameter("xtel");
                datos[4] = request.getParameter("xcel");
                datos[5] = request.getParameter("xsex");
                datos[6] = request.getParameter("xfec");
                datos[7] = request.getParameter("xest");
                objDatos.grabarNuevoAlumno(datos);
            }else {
                 String[] datos = new String[9];
                 datos[0] = request.getParameter("xcod");
                 datos[1] = request.getParameter("xnom");
                 datos[2] = request.getParameter("xdir");
                 datos[3] = request.getParameter("xema");
                 datos[4] = request.getParameter("xtel");
                 datos[5] = request.getParameter("xcel");
                 datos[6] = request.getParameter("xsex");
                 datos[7] = request.getParameter("xfec");
                 datos[8] = request.getParameter("xest");
                 objDatos.modificarAlumno(datos);
             }
         }
         request.getRequestDispatcher("/controladorPrincipal?accion=listadoAlumnos").forward(
            request,response );
     }
       else if ( accion.compareTo( "GRABAR_CURSO") == 0 ) {
          if ( request.getParameter( "boton" ).compareTo( "GRABAR" ) == 0 ) {
             String operacion = request.getParameter("operacion");
             if ( operacion.equals("INSERT")) {
                String[] datos = new String[9];
                datos[0] = request.getParameter("xnom");
                datos[1] = request.getParameter("xcos");
                datos[2] = request.getParameter("xini");
                datos[3] = request.getParameter("xfin");
                datos[4] = request.getParameter("xdur");
                datos[5] = request.getParameter("xses");
                datos[6] = request.getParameter("xcap");
                datos[7] = request.getParameter("xins");
                datos[8] = request.getParameter("xest");
                objDatos.grabarNuevoCurso(datos);
            }else {
                 String[] datos = new String[10];
                 datos[0] = request.getParameter("xcod");
                 datos[1] = request.getParameter("xnom");
                 datos[2] = request.getParameter("xcos");
                datos[3] = request.getParameter("xini");
                datos[4] = request.getParameter("xfin");
                datos[5] = request.getParameter("xdur");
                datos[6] = request.getParameter("xses");
                datos[7] = request.getParameter("xcap");
                datos[8] = request.getParameter("xins");
                datos[9] = request.getParameter("xest");
                 objDatos.modificarCurso(datos);
             }
         }
         request.getRequestDispatcher("/controladorPrincipal?accion=listadoCursos").forward(
            request,response );
     }
       else if ( accion.compareTo( "GRABAR_USUARIO") == 0 ) {
          if ( request.getParameter( "boton" ).compareTo( "GRABAR" ) == 0 ) {
             String operacion = request.getParameter("operacion");
             if ( operacion.equals("INSERT")) {
                String[] datos = new String[3];
                datos[0] = request.getParameter("xnom");
                datos[1] = request.getParameter("xcla");
                datos[2] = request.getParameter("xest");
                objDatos.grabarNuevoUsuario(datos);
            }else {
                 String[] datos = new String[4];
                 datos[0] = request.getParameter("xcod");
                 datos[1] = request.getParameter("xnom");
                 datos[2] = request.getParameter("xcla");
                 datos[3] = request.getParameter("xest");
                 objDatos.modificarUsuario(datos);
             }
         }
         request.getRequestDispatcher("/controladorPrincipal?accion=listadoUsuarios").forward(
            request,response );
     }
       else if ( accion.compareTo( "modificarArea" ) == 0 ) {
         String xcod = request.getParameter( "xcod" );
         Vector registro = objDatos.buscarArea(xcod);

         request.setAttribute( "registro", registro );
         request.setAttribute( "operacion","UPDATE");
         request.setAttribute( "titulo","Modificar Area");
         request.getRequestDispatcher( "/mantenimientos/editarAreas.jsp" ).forward( 
             request,response );
     }
       else if ( accion.compareTo( "modificarAlumno" ) == 0 ) {
         String xcod = request.getParameter( "xcod" );
         Vector registro = objDatos.buscarAlumno(xcod);

         request.setAttribute( "registro", registro );
         request.setAttribute( "operacion","UPDATE");
         request.setAttribute( "titulo","Modificar Alumno");
         request.getRequestDispatcher( "/mantenimientos/editarAlumnos.jsp" ).forward( 
             request,response );
     }
       else if ( accion.compareTo( "modificarCurso" ) == 0 ) {
         String xcod = request.getParameter( "xcod" );
         Vector registro = objDatos.buscarCurso(xcod);

         request.setAttribute( "registro", registro );
         request.setAttribute( "operacion","UPDATE");
         request.setAttribute( "titulo","Modificar Curso");
         request.getRequestDispatcher( "/mantenimientos/editarCursos.jsp" ).forward( 
             request,response );
     }
       else if ( accion.compareTo( "modificarUsuario" ) == 0 ) {
         String xcod = request.getParameter( "xcod" );
         Vector registro = objDatos.buscarUsuario(xcod);

         request.setAttribute( "registro", registro );
         request.setAttribute( "operacion","UPDATE");
         request.setAttribute( "titulo","Modificar Usuario");
         request.getRequestDispatcher( "/mantenimientos/editarUsuarios.jsp" ).forward( 
             request,response );
     }
       else
          out.println("Accion: (" + accion + ") no reconocida...");
   }catch(Exception ex) {
       System.out.println( ex.toString() );   
   } finally { 
      out.close();
   }
}


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
