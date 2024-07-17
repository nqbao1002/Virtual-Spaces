package com.virtualspaces.model;

import java.io.Serializable;

public class VideoType implements Serializable {
    public int TypeID;
    public String TypeName;
    public String TypeIMG;

    public VideoType() {
    }

    
    public VideoType(String TypeName, String TypeIMG) {
        this.TypeID = 1;
        this.TypeName = TypeName;
        this.TypeIMG = TypeIMG;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    public String getTypeIMG() {
        return TypeIMG;
    }

    public void setTypeIMG(String TypeIMG) {
        this.TypeIMG = TypeIMG;
    }   
}
