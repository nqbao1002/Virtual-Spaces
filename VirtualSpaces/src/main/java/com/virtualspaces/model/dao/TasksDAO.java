/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model.dao;

import com.virtualspaces.model.Task;
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
public class TasksDAO {

    public void insertTask(Task task) {
        String sql = "insert into task (TaskName, TaskDescription, date, timestart,timeEnd, userid) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, task.getTaskName());
            pre.setString(2, task.getTaskDescription());
            pre.setTimestamp(3, task.getDate());
            pre.setTimestamp(4, task.getTimeStart());
            pre.setTimestamp(5, task.getTimeEnd());
            pre.setString(6, task.getUserId());
            pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Task checkTask(int id) {
        String sql = "SELECT * FROM task WHERE taskID = ?";
        try ( Connection con = DBUtils.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Task task = new Task();
                    task.setTaskID(rs.getInt("taskID"));
                    task.setTaskName(rs.getString("taskName"));
                    task.setTaskDescription(rs.getString("taskDescription"));
                    task.setDate(rs.getTimestamp("date"));
                    task.setTimeStart(rs.getTimestamp("timeStart"));
                    task.setTimeEnd(rs.getTimestamp("timeEnd"));
                    task.setUserId(rs.getString("userId"));
                    return task;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Task> list(String userId) {
        List<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM task where userId = ?";
        try ( Connection con = DBUtils.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userId);
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Task task = new Task();
                    task.setTaskID(rs.getInt("taskID"));
                    task.setTaskName(rs.getString("taskName"));
                    task.setTaskDescription(rs.getString("taskDescription"));
                    task.setDate(rs.getTimestamp("date"));
                    task.setTimeStart(rs.getTimestamp("timeStart"));
                    task.setTimeEnd(rs.getTimestamp("timeEnd"));
                    task.setUserId(rs.getString("userId"));
                    list.add(task);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void deleteTask(int id) {
        String sql = "delete from task where taskid = ?";
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

    public void updateTask(Task task) {
        String sql = "UPDATE task SET taskDescription = ?, date = ?, timeStart = ?, timeEnd = ? WHERE taskid = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, task.getTaskDescription());
            ps.setTimestamp(2, task.getDate());
            ps.setTimestamp(3, task.getTimeStart());
            ps.setTimestamp(4, task.getTimeEnd());
            ps.setInt(5, task.getTaskID());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
