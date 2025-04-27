/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Examination;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author latis
 */
public class ExampaperServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///exam", "root", "mysql");

            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select Correct from paper");
            
           
            //String s1 = rs.getString("Correct");

            PrintWriter out = response.getWriter();
            String answer1 = request.getParameter("q1");
            String answer2 = request.getParameter("q2");
            String answer3 = request.getParameter("q3");
            String answer4 = request.getParameter("q4");
            String answer5 = request.getParameter("q5");
            int score = 0;

            if ("identifier".equals(answer1)) {
                score++;
            }
            if ("Sound Sentry".equals(answer2)) {
                score++;
            }
            if ("Client".equals(answer3)) {
                score++;
            }
            if ("World Wide Web".equals(answer4)) {
                score++;
            }
            if ("Modem".equals(answer5)) {
                score++;
            }
            out.print(score);
            request.setAttribute("score", score);
            request.getRequestDispatcher("exam.jsp").forward(request, response);

        }catch(Exception e){
            System.out.println("failed...!!!");
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
