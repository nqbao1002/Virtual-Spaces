/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.virtualspaces.controller.admin;

import com.google.gson.Gson;
import com.virtualspaces.model.Video;
import com.virtualspaces.model.dao.VideoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a
 */
@WebServlet(name = "VideoController", urlPatterns = {"/video-controller"})
public class VideoController extends HttpServlet {

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
        // Tiếp nhận dữ liệu từ request
        String type = request.getParameter("type");
        String videoId = request.getParameter("videoId");
        String status = null;
        // Tạo thực thể Video
        Video video = new Video(type, videoId);

        // Sử dụng VideoDAO để insert video
        VideoDAO dao = new VideoDAO();
        int insertResult = dao.insertVideo(video);

        // Chuẩn bị response
       
        // Kiểm tra kết quả và trả về thông báo
        if (insertResult == 1) {
            // Nếu insert thành công
            status = "INSERT SUCCESFULLY";
        } else if(insertResult == 2) {
             status = "DUPLICATE VIDEO!!";
        }else{
             status = "INSERT FAILED!!";
        }
        String json = new Gson().toJson(status);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.getWriter().write(json);

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
