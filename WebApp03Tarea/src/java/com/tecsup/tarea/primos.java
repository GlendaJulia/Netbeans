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
@WebServlet(name = "primos", urlPatterns = {"/primos"})
public class primos extends HttpServlet {

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
            String par1 = request.getParameter("b");
            int num = Integer.parseInt(par1);
            int i;
            int n=4;
            int cont=2;
            String cad="";
            out.println("<h1>Los primeros numeros primos</h1>");
            out.println("<h2>Los <b>"+ num +"</b> primeros primos son:</h2>");
            if(num>2){
            cad="2 - 3";
            while(cont<num){
                i=2;
                while(i<=n){
                    if(i==n){
                    cad=cad+" - "+n;
                    cont=cont+1;
                    }else{
                    if(n % i==0){
                    i=n;
                    }
                    }
                    i=i+1;
                }
                n=n+1;
            }
            out.println("<h3><b>"+ cad +"</b></h3>");
        }else{
            if(num>0){
            if(num==1){
                out.println("<h3><b>Es primo 2</b></h3>");
            }else{
            out.println("<h3><b>Es primo 2, 3</b></h3>");
            }
            }else{
            out.println("<h3><b>Ingresa numeros positivos</b></h3>");
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
        try {
            String par1 = request.getParameter("b");
            int num = Integer.parseInt(par1);
            int i;
            int n=4;
            int cont=2;
            String cad="";
            out.println("<h1>Los primeros numeros primos</h1>");
            out.println("<h2>Los <b>"+ num +"</b> primeros primos son:</h2>");
            if(num>2){
            cad="2 - 3";
            while(cont<num){
                i=2;
                while(i<=n){
                    if(i==n){
                    cad=cad+" - "+n;
                    cont=cont+1;
                    }else{
                    if(n % i==0){
                    i=n;
                    }
                    }
                    i=i+1;
                }
                n=n+1;
            }
            out.println("<h3><b>"+ cad +"</b></h3>");
        }else{
            if(num>0){
            if(num==1){
                out.println("<h3><b>Es primo 2</b></h3>");
            }else{
            out.println("<h3><b>Es primo 2, 3</b></h3>");
            }
            }else{
            out.println("<h3><b>Ingresa numeros positivos</b></h3>");
            }
        }
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
