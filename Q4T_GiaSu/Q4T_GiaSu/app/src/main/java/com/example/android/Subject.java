package com.example.android;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {
    @SerializedName("id_user")
    @Expose
    private String id_user;
    @SerializedName("name_subjects")
    @Expose
    private String name_subjects ;
    @SerializedName("class")
    @Expose
    private String classname ;


    public String getName_subjects() {
        return name_subjects;
    }

    public void setName_subjects(String name_subjects) {
        this.name_subjects = name_subjects;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}

