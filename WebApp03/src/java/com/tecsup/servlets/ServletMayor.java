/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "ServletMayor", urlPatterns = {"/ServletMayor"})
public class ServletMayor extends HttpServlet {

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
        
        int a = 20;
        int b = 50;
        int mayor = a;
        int menor = b;
         if ( b > a ){
             mayor = b;
             menor = a;
         }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMayor</title>");
            out.println("<style>table, th, td {\n" +
"    border: 3px solid pink;\n" +
"    border-collapse: collapse;\n" +
"    text-align: center;\n" +
"}\n" +
"th, td {\n" +
"    padding: 5px;\n" +
"    text-align: left;\n" +
"}\n" +
"#gle{\n" +
"  text-align: center;\n" +
"}</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table style=\"width:50%\" style=\"border: 3px solid pink\">\n" +
"  <tr>\n" +
"    <th id=\"gle\" colspan=\"2\" bgcolor=\"red\" style=\"color:white; font-size:25px;\">Calculo de Mayor y Menor</th>\n" +
"  </tr>\n" +
"  <tr>\n" +
"    <th>Numero Mayor</th>\n" +
"    <th>Numero Menor</th>\n" +
"  </tr>\n" +
"  <tr>\n" +
"    <th>"+ mayor +"</th>\n" +
"    <th>"+ menor +"</th>\n" +
"  </tr>\n" +
"  <tr>\n" +
"    <th colspan=\"2\" style=\"color:skyblue;\">Glenda Julia, Merma Mayhua</th>\n" +
"  </tr>\n" +
"</table>");
            out.println("</body>");
            out.println("</html>");
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
