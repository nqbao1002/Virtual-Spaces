/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model.dao;

import com.virtualspaces.model.Fortune;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author a
 */
public class FortuneDAO {

    public Fortune getFortune() {
        List<Fortune> list = new ArrayList<Fortune>();
        String sql = "SELECT * FROM Fortune";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fortune fortune = new Fortune();
                fortune.setFortuneID(rs.getInt("FortuneID"));
                fortune.setFortuneContent(rs.getString("FortuneContent"));
                list.add(fortune);
            }

            Random n = new Random();
            int randomFortune = n.nextInt(list.size()) + 1;
            return list.get(randomFortune);

        } catch (SQLException e) {
            System.out.println("Servlet error, detail: " + e.getMessage());
        }
        return null;
    }

    public void insertFortune(String content) {
        String sql = "insert into fortune (fortuneContent) values(?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, content);
            ps.executeUpdate();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFortune(int id) {
        String sql = "delete from fortune where fortuneid = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateFortune(Fortune fortune) {
        String sql = "update fortune set fortuneContent = ? where fortuneId = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, fortune.getFortuneID());
            ps.setString(1, fortune.getFortuneContent());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Fortune> listFortunes(){
        List<Fortune> listFortunes = new ArrayList<>();
        String sql = "SELECT * FROM Fortune";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fortune fortune = new Fortune();
                fortune.setFortuneID(rs.getInt("FortuneID"));
                fortune.setFortuneContent(rs.getString("FortuneContent"));
                listFortunes.add(fortune);
            }
            return listFortunes;
        } catch (SQLException e) {
            System.out.println("Servlet error, detail: " + e.getMessage());
        }
        return null;
    }
}
