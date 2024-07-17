/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model.dao;

import com.virtualspaces.model.Sound;
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
public class SoundDAO {

    public List<Sound> getSoundList() {
        List<Sound> list = new ArrayList<Sound>();
        String sql = "SELECT * FROM Sound";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Sound sound = new Sound();
                sound.setSoundId(rs.getInt("soundid"));
                sound.setSoundName(rs.getString("SoundName"));
                sound.setSoundURL(rs.getString("SoundURL"));
                list.add(sound);
            }
            return list;

        } catch (SQLException e) {
            System.out.println("Servlet error, detail: " + e.getMessage());
        }
        return null;

    }

    public Sound check(int id) {
        String sql = "SELECT * FROM sound WHERE soundid = ?";
        try ( Connection con = DBUtils.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Sound sound = new Sound();
                    sound.setSoundId(rs.getInt("soundid"));
                    sound.setSoundName(rs.getString("SoundName"));
                    sound.setSoundURL(rs.getString("SoundURL"));
                    return sound;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error checking sound: " + e.getMessage());
        }
        return null;
    }

    public void deleteSound(int id) {
        String sql = "delete from Sound where soundid = ?";
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

    public void updateSound(Sound sound) {
        String sql = "update sound set soundname = ?, soundurl = ? where soundid = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sound.getSoundName());
            ps.setString(2, sound.getSoundURL());
            ps.setInt(3, sound.getSoundId());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertSound(String name, String url) {
        String sql = "insert into sound (soundname, soundurl) values(?,?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, url);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
