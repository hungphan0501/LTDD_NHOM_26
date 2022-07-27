package com.example.android;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class tutar {
    @SerializedName("grade")
    @Expose
    private String grade;
    @SerializedName("level")
    @Expose
    private String level ;
    @SerializedName("tutor_id")
    @Expose
    private String tutor_id ;

    public String getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(String tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
