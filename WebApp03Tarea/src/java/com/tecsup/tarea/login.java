/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.tarea;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            String xcod = request.getParameter("xcod");
            String xcla = request.getParameter("xcla");
            String codigo = "Tecsup";
            String clave = "RCDTecsup2";
            if (xcod.equals(codigo) && xcla.equals(clave)){
                response.sendRedirect("/WebApp03Tarea/servlets.html");
            }else{
                if(xcod.equals(codigo) == false && xcla.equals(clave)== false){
                    out.println("<h1>¡ERROR!</h1>");
                    out.println("<h2>El codigo y la clave son incorrectos</h2>");
                    out.println("<form method=\"post\" action=\"/WebApp03Tarea/index.html\">\n" +
"            <input class=\"glen\" type=\"submit\" value=\"Volver a intentarlo\">\n" +
"        </form>");
                }else if (xcod.equals(codigo) == false && xcla.equals(clave)== true){
                    out.println("<h1>¡ERROR!</h1>");
                    out.println("<h2>El codigo ingresado es incorrecto</h2>");
                    out.println("<form method=\"post\" action=\"/WebApp03Tarea/index.html\">\n" +
"            <input class=\"glen\" type=\"submit\" value=\"Volver a intentarlo\">\n" +
"        </form>");
                }else{
                    out.println("<h1>¡ERROR!</h1>");
                    out.println("<h2>La clave ingresada es incorrecta</h2>");
                    out.println("<form method=\"post\" action=\"/WebApp03Tarea/index.html\">\n" +
"            <input class=\"glen\" type=\"submit\" value=\"Volver a intentarlo\">\n" +
"        </form>");
                }
            }
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
