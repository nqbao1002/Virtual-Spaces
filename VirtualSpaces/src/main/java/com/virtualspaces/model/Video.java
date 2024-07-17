/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model;

/**
 *
 * @author a
 */
public class Video {
    public int VideoID;
    public String VideoType;
    public String VideoURL;

    public Video() {
    }

    public Video(String VideoType, String VideoURL) {
        this.VideoID = 1;
        this.VideoType = VideoType;
        this.VideoURL = VideoURL;
    }

    public int getVideoID() {
        return VideoID;
    }

    public void setVideoID(int VideoID) {
        this.VideoID = VideoID;
    }

    public String getVideoType() {
        return VideoType;
    }

    public void setVideoType(String VideoType) {
        this.VideoType = VideoType;
    }

    public String getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(String VideoURL) {
        this.VideoURL = VideoURL;
    }
    
}
