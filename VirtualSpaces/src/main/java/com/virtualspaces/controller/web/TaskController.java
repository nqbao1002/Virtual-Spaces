/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.virtualspaces.controller.web;

import com.virtualspaces.model.Task;
import com.virtualspaces.model.dao.TasksDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "TaskController", urlPatterns = {"/TaskController"})
public class TaskController extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        TasksDAO dao = new TasksDAO();

        if (action.equals("task")) {
            String userId = (String) session.getAttribute("id");
            List<Task> list = dao.list(userId);
            if (list == null) {
                list = new ArrayList<>();
            }
            session.setAttribute("listTask", list);
            request.getRequestDispatcher("task.jsp").include(request, response);

        } else if (action.equals("detail")) {
            String taskId = request.getParameter("taskId");
            Task task = dao.checkTask(Integer.parseInt(taskId));
            request.setAttribute("task", task);
            request.getRequestDispatcher("task.jsp").forward(request, response);
        } else if (action.equals("add")) {
            Task task = new Task();
            task.setTaskName(request.getParameter("taskName"));
            task.setTaskDescription(request.getParameter("taskDescription"));
            String date = request.getParameter("date");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            task.setDate(new java.sql.Timestamp(parsedDate.getTime()));
            String timeStartStr = request.getParameter("timeStart");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Date parsedTimeStart = timeFormat.parse(timeStartStr);
            task.setTimeStart(new java.sql.Timestamp(parsedTimeStart.getTime()));
            String timeEnd = request.getParameter("timeEnd");
            Date parsedTimeEnd = timeFormat.parse(timeEnd);
            task.setTimeEnd(new java.sql.Timestamp(parsedTimeEnd.getTime()));
            task.setUserId((String) session.getAttribute("id"));
            dao.insertTask(task);
            List<Task> list = dao.list(task.getUserId());
            if (list == null) {
                list = new ArrayList<>();
            }
            session.setAttribute("listTask", list);
            request.getRequestDispatcher("task.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            String taskId = request.getParameter("taskId");
            dao.deleteTask(Integer.parseInt(taskId));
            String userId = (String) session.getAttribute("id");
            List<Task> list = dao.list(userId);
            if (list == null) {
                list = new ArrayList<>();
            }
            session.setAttribute("listTask", list);
            request.getRequestDispatcher("task.jsp").include(request, response);
        } else if (action.equals("update")) {
            Task task = new Task();
            task.setTaskID(Integer.parseInt(request.getParameter("taskId")));
            task.setTaskDescription(request.getParameter("taskDescription"));
            String date = request.getParameter("date");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            task.setDate(new java.sql.Timestamp(parsedDate.getTime()));
            String timeStartStr = request.getParameter("timeStart");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Date parsedTimeStart = timeFormat.parse(timeStartStr);
            task.setTimeStart(new java.sql.Timestamp(parsedTimeStart.getTime()));
            String timeEnd = request.getParameter("timeEnd");
            Date parsedTimeEnd = timeFormat.parse(timeEnd);
            task.setTimeEnd(new java.sql.Timestamp(parsedTimeEnd.getTime()));
            System.out.println(task.toString());
            dao.updateTask(task);
            String userId = (String) session.getAttribute("id");
            List<Task> list = dao.list(userId);
            if (list == null) {
                list = new ArrayList<>();
            }
            session.setAttribute("listTask", list);
            request.getRequestDispatcher("task.jsp").include(request, response);

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
