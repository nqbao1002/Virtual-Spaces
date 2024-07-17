/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.virtualspaces.controller.admin;

import com.virtualspaces.model.Sound;
import com.virtualspaces.model.dao.SoundDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AdminSoundController", urlPatterns = {"/AdminSoundController"})
public class AdminSoundController extends HttpServlet {

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
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            SoundDAO dao = new SoundDAO();
            if (action.equals("sound")) {
                List<Sound> list = dao.getSoundList();
                session.setAttribute("listSound", list);
                response.sendRedirect("AdminSound.jsp");

            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("soundId"));
                dao.deleteSound(id);
                List<Sound> list = dao.getSoundList();
                if (list == null) {
                    list = new ArrayList<>();
                    request.setAttribute("listSound", list);
                }
                session.setAttribute("listSound", list);
                response.sendRedirect("AdminSound.jsp");
//            } else if (action.equals("update")) {
//                String idRequest = request.getParameter("soundId");
//                int id = 0;
//                if (idRequest != null) {
//                    id = Integer.parseInt(idRequest);
//                    request.setAttribute("soundId", id);
//                }
//                request.setAttribute("action", "update-1");
//                request.getRequestDispatcher("EditSound.jsp").forward(request, response);
            } else if (action.equals("update")) {
                String idRequest = request.getParameter("soundId");
                int id = Integer.parseInt(idRequest);
                System.out.println(id);
                Sound sound = dao.check(id);
                sound.setSoundId(id);
                if (request.getParameter("soundName") == null) {
                    sound.setSoundName(sound.getSoundName());
                } else {
                    sound.setSoundName(request.getParameter("soundName"));
                }

                if (request.getParameter("soundUrl") == null) {
                    sound.setSoundURL(sound.getSoundURL());
                } else {
                    sound.setSoundURL(request.getParameter("soundUrl"));
                }
                dao.updateSound(sound);
                List<Sound> list = dao.getSoundList();
                if (list == null) {
                    list = new ArrayList<>();
                    request.setAttribute("listSound", list);
                }
                session.setAttribute("listSound", list);
                response.sendRedirect("AdminSound.jsp");

//            } else if (action.equals("add")) {
//                request.setAttribute("action", "create");
//                request.getRequestDispatcher("EditSound.jsp").forward(request, response);
            } else if (action.equals("add")) {
                Sound sound = new Sound();
                sound.setSoundName(request.getParameter("soundName"));
                sound.setSoundURL(request.getParameter("soundUrl"));
                dao.insertSound(sound.getSoundName(), sound.getSoundURL());
                List<Sound> list = dao.getSoundList();
                if (list == null) {
                    list = new ArrayList<>();
                    request.setAttribute("listSound", list);
                }
                session.setAttribute("listSound", list);
                response.sendRedirect("AdminSound.jsp");
            }
            System.out.println(action);

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
