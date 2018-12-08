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
@WebServlet(name = "ServletSuma", urlPatterns = {"/ServletSuma"})
public class ServletSuma extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
                              HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String par1 = request.getParameter("a");
            String par2 = request.getParameter("b");
            int n1 = Integer.parseInt(par1);
            int n2 = Integer.parseInt(par2);
            int rp = n1 + n2;
            out.println("Suma de " + n1 + " + " + n2 + " = " + rp);
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String par1 = request.getParameter("a");
            String par2 = request.getParameter("b");
            int n1 = Integer.parseInt(par1);
            int n2 = Integer.parseInt(par2);
            int rp = n1 + n2;
            out.println("<h1>Suma Utilizando Metodo doPost</h1>");
            out.println("<h3>Nro 1: <b>"+ n1 +"</b></h3>");
            out.println("<h3>Nro 2: <b>"+ n2 +"</b></h3>");
            out.println("<h2>Resultado de Suma es: <b>"+ rp +"</b></h2>");
            
        } finally { 
            out.close();
        }
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
