package com.virtualspaces.controller.web;

import com.virtualspaces.model.Stats;
import com.virtualspaces.model.UserGoogleDto;
import com.virtualspaces.model.dao.StatsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
@WebServlet(name = "LogoutController", urlPatterns = {"/LogoutController"})
public class LogoutController extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            if (session != null) {
                LocalDateTime loginTime = (LocalDateTime) session.getAttribute("loginTime");
                if (loginTime != null) {
                    LocalDateTime logoutTime = LocalDateTime.now();
                    long timeSpentSeconds = loginTime.until(logoutTime, ChronoUnit.SECONDS);
                    double timeSpentHours = (double) timeSpentSeconds / 3600.0;
                    UserGoogleDto user = (UserGoogleDto) session.getAttribute("user");
                    Stats stats = (Stats) session.getAttribute("stats");
                    StatsDAO dao = new StatsDAO();

                    if (timeSpentHours > 0) {
                        dao.update(user.getId(), timeSpentHours + stats.getHours());
                    }
                    session.removeAttribute("loginTime");
                }
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath() + "/Home.jsp");
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
