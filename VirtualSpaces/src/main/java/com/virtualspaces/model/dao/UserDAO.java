/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model.dao;

import com.virtualspaces.model.Stats;
import com.virtualspaces.model.UserGoogleDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class UserDAO {

    public void insertUser(UserGoogleDto user) {
        String sql = "insert into users (id, email, name, given_name, family_name, picture, roleid) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, user.getId());
            pre.setString(2, user.getEmail());
            pre.setString(3, user.getName());
            pre.setString(4, user.getGiven_name());
            pre.setString(5, user.getFamily_name());
            pre.setString(6, user.getPicture());
            pre.setInt(7, user.getRoleId());
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public UserGoogleDto find(String id) {
        String sql = "select * from users where id = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                UserGoogleDto user = new UserGoogleDto();
                user.setId(rs.getString("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setGiven_name(rs.getString("given_name"));
                user.setFamily_name(rs.getString("family_name"));
                user.setPicture(rs.getString("picture"));
                user.setRoleId(rs.getInt("roleid"));
                return user;

            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<UserGoogleDto> list() {
        String sql = "SELECT u.id, u.email, u.name, s.days, s.hours "
                + "FROM users u "
                + "JOIN stats s ON u.id = s.userid";
        try {
            List<UserGoogleDto> list = new ArrayList<>();
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                UserGoogleDto user = new UserGoogleDto();
                user.setId(rs.getString("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                Stats stats = new Stats();
                stats.setDays(rs.getInt("days"));
                stats.setHours(rs.getDouble("hours"));
                user.setUserStats(stats);
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
