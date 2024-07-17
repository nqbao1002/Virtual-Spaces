/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model.dao;

import com.virtualspaces.model.Media;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class mediaDAO {

    public void insertMedia(Media media) {
        String sql = "insert into media (mediaUrl, userId) values (?,?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, media.getMediaUrl());
            ps.setString(2, media.getUserID());
            ps.execute();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean findUrl(String url, String userid) {
        String sql = "SELECT * FROM Media WHERE mediaurl = ? and userid = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, url);
            ps.setString(2, userid);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while checking URL existence: " + e.getMessage());
        }
        return false;
    }

}
