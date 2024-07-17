/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model.dao;

import com.virtualspaces.model.VideoType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class VideoTypeDAO {

    public List<VideoType> returnListType() {
        List<VideoType> list = new ArrayList<VideoType>();
        String sql = "SELECT * FROM VideoType";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                VideoType type = new VideoType();
                type.setTypeName(rs.getString("TypeName"));
                type.setTypeIMG(rs.getString("TypeIMG"));
                list.add(type);
            }
        } catch (SQLException e) {
            System.out.println("Servlet error, detail: " + e.getMessage());
        }
        return list;
    }
}
