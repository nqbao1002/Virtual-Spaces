/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.virtualspaces.controller.admin;

import com.virtualspaces.model.Fortune;
import com.virtualspaces.model.dao.FortuneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AdminFortuneController", urlPatterns = {"/AdminFortuneController"})
public class AdminFortuneController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            FortuneDAO dao = new FortuneDAO();
            System.out.println(action);
            if (action.equals("fortune")) {
                List<Fortune> list = dao.listFortunes();
                if (list == null) {
                    list = new ArrayList<>();
                    request.setAttribute("listFortune", list);
                }
                session.setAttribute("listFortune", list);
                response.sendRedirect("AdminFortune.jsp");
//            } else if (action.equals("add")) {
//                request.setAttribute("action", "insert");
//                request.getRequestDispatcher("EditFortune.jsp").forward(request, response);
            } else if (action.equals("add")) {
                String content = request.getParameter("fortuneContent");
                dao.insertFortune(content);
                List<Fortune> list = dao.listFortunes();
                if (list == null) {
                    list = new ArrayList<>();
                    request.setAttribute("listFortune", list);
                }
                session.setAttribute("listFortune", list);
                response.sendRedirect("AdminFortune.jsp");
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("fortuneId"));
                dao.deleteFortune(id);
                List<Fortune> list = dao.listFortunes();
                if (list == null) {
                    list = new ArrayList<>();
                    request.setAttribute("listFortune", list);
                }
                session.setAttribute("listFortune", list);
                response.sendRedirect("AdminFortune.jsp");
//            } else if (action.equals("update")) {
//                String requestId = request.getParameter("fortuneId");
//                if (requestId != null) {
//                    int id = Integer.parseInt(requestId);
//                    request.setAttribute("fortuneId", id);
//                }
//                request.setAttribute("action", "update-1");
//                request.getRequestDispatcher("EditFortune.jsp").forward(request, response);
            } else if (action.equals("update")) {
                String requestId = request.getParameter("fortuneId");
                Fortune fortune = new Fortune();
                if (requestId != null) {
                    fortune.setFortuneID(Integer.parseInt(requestId));
                }
                fortune.setFortuneContent(request.getParameter("fortuneContent"));
                dao.updateFortune(fortune);
                List<Fortune> list = dao.listFortunes();
                if (list == null) {
                    list = new ArrayList<>();
                    request.setAttribute("listFortune", list);
                }
                session.setAttribute("listFortune", list);
                response.sendRedirect("AdminFortune.jsp");

            }
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
