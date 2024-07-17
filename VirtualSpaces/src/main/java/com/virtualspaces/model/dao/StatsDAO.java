/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model.dao;

import com.virtualspaces.model.Stats;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class StatsDAO {
    public void insert (Stats stats){
        String sql = "insert into stats (days, hours, userid, dateLoginLastest) values (?, ?, ?, ?)";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, stats.getDays());
            ps.setDouble(2, stats.getHours());
            ps.setString(3, stats.getUserId());
            ps.setDate(4, stats.getLoginLastest());
            ps.execute();
            con.close(); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Stats check (String userId){
        String sql = "select * from stats where userid = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Stats stats = new Stats();
                stats.setDays(rs.getInt("days"));
                stats.setHours(rs.getFloat("hours"));
                stats.setUserId(rs.getString("userid"));
                stats.setLoginLastest(rs.getDate("dateLoginLastest"));
                return stats;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void update (String userId, double b){
        String sql = "update stats set hours = ? where userid = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, b);
            ps.setString(2, userId);
            ps.execute();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateDate (String userId, int a, Date date){
        String sql = "update stats set days = ?, dateLoginLastest = ? where userid = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a);
            ps.setDate(2, date);
            ps.setString(3, userId);
            ps.execute();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
}
