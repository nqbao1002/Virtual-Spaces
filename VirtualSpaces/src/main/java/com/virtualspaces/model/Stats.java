/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Stats {
    private int StatsId;
    private int days;
    private double hours;
    private String userId;
    private Date loginLastest;

    public Stats() {
    }

    public Stats(int StatsId, int days, double hours, String userId, Date loginLastest) {
        this.StatsId = StatsId;
        this.days = days;
        this.hours = hours;
        this.userId = userId;
        this.loginLastest = loginLastest;
    }

    public Date getLoginLastest() {
        return loginLastest;
    }

    public void setLoginLastest(Date loginLastest) {
        this.loginLastest = loginLastest;
    }

    
    public int getStatsId() {
        return StatsId;
    }

    public int getDays() {
        return days;
    }

    public double getHours() {
        return hours;
    }

    public String getUserId() {
        return userId;
    }

    public void setStatsId(int StatsId) {
        this.StatsId = StatsId;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
}
