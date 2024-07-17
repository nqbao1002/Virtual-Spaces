/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model.dao;

import com.virtualspaces.model.Video;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class VideoDAO {

    public List<Video> getListByType(String videoType) {
        List<Video> list = new ArrayList<Video>();
        String sql = "SELECT VideoID, VideoType, VideoURL FROM Video WHERE VideoType = ?";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, videoType);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Video video = new Video();
                video.setVideoID(rs.getInt("VideoID"));
                video.setVideoType(rs.getString("VideoType"));
                video.setVideoURL(rs.getString("VideoURL"));
                list.add(video);
            }
        } catch (SQLException e) {
            System.out.println("Servlet error, detail: " + e.getMessage());
        }
        return list;
    }

    public int insert(Video video) {
        // Tiếp tục với logic chèn
        String sql = "INSERT INTO Video VALUES(?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, video.getVideoType());
            ps.setString(2, video.getVideoURL());

            ps.executeUpdate();
            return 1; // Chèn thành công
        } catch (SQLException e) {
            System.out.println("Lỗi Servlet, chi tiết: " + e.getMessage());
            return 0; // Lỗi khi chèn
        }

    }

    public boolean getVideoByURL(String URL) {
        String sql = "SELECT VideoID FROM Video WHERE VideoURL = \'" + URL + "\'";
        try {
            Connection con = DBUtils.getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(sql);

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Servlet error, detail: " + e.getMessage());
        }
        return false;
    }

    public int insertVideo(Video video) {
        String sql = "INSERT INTO Video VALUES(?, ?)";
        if (this.getVideoByURL(video.getVideoURL())) {
            return 2;
        } else {
            try {
                Connection con = DBUtils.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, video.getVideoType());
                ps.setString(2, video.getVideoURL());

                ps.executeUpdate();
                return 1; // Chèn thành công
            } catch (SQLException e) {
                System.out.println("Lỗi Servlet, chi tiết: " + e.getMessage());
                return 0; // Lỗi khi chèn
            }
        }

    }
}
