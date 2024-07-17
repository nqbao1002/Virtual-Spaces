/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualspaces.model;

/**
 *
 * @author a
 */
public class Fortune {
    public int fortuneID;
    public String fortuneContent;

    public Fortune() {
    }

    public Fortune(String FortuneContent) {
        this.fortuneID = 1;
        this.fortuneContent = FortuneContent;
    }

    public int getFortuneID() {
        return fortuneID;
    }

    public void setFortuneID(int FortuneID) {
        this.fortuneID = FortuneID;
    }

    public String getFortuneContent() {
        return fortuneContent;
    }

    public void setFortuneContent(String FortuneContent) {
        this.fortuneContent = FortuneContent;
    }

    @Override
    public String toString() {
        return "Fortune{" + "FortuneID=" + fortuneID + ", FortuneContent=" + fortuneContent + '}';
    }
    
    
}
