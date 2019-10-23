package com.example.a16478004_wxy.Module;

import java.io.Serializable;

public class Authors implements Serializable {

    //authorid，authorname
    String authorname;
    int authorid;

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorname='" + authorname + '\'' +
                ", authorid=" + authorid +
                '}';
    }

}
