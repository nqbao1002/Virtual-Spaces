/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model;

/**
 *
 * @author ADMIN
 */
public class Media {
    private int id;
    private String mediaUrl;
    private String userID;

    public Media(int id, String mediaUrl, String userID) {
        this.id = id;
        this.mediaUrl = mediaUrl;
        this.userID = userID;
    }

    public Media() {
    }

    public int getId() {
        return id;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public String getUserID() {
        return userID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    
}
