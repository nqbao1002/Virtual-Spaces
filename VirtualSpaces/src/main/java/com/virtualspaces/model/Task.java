/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model;


import java.sql.Timestamp;

/**
 *
 * @author ADMIN
 */
public class Task {

    private int taskID;
    private String taskName;
    private String taskDescription;
    private Timestamp date;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private String userId;

    public Task(String taskName, String taskDescription, Timestamp date, Timestamp timeStart, Timestamp timeEnd, String userId) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.userId = userId;
    }
    public Task(){
        
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Timestamp getDate() {
        return date;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public String getUserId() {
        return userId;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" + "taskID=" + taskID + ", taskName=" + taskName + ", taskDescription=" + taskDescription + ", date=" + date + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", userId=" + userId + '}';
    }

    
    
}
