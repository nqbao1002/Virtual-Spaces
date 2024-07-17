/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model;

/**
 *
 * @author a
 */
public class Sound {
    private int soundId;
    private String soundName;
    private String soundURL;

    public Sound() {
    }

    public Sound(String soundName, String soundURL, int soundId) {
        this.soundName = soundName;
        this.soundURL = soundURL;
        this.soundId = soundId;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public String getSoundURL() {
        return soundURL;
    }

    public void setSoundURL(String soundURL) {
        this.soundURL = soundURL;
    }

    public int getSoundId() {
        return soundId;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }
    
    
    
}
