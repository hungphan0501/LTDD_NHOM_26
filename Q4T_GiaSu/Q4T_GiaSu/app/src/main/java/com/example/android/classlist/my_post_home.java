package com.example.android.classlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class my_post_home {
    @SerializedName("lesson_detail_id")
    @Expose
    private String lesson_detail_id;
    @SerializedName("tutor_id")
    @Expose
    private String tutor_id;
    @SerializedName("grade")
    @Expose
    private String grade;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("fee")
    @Expose
    private String fee;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("hour")
    @Expose
    private String hour;

    public String getLesson_detail_id() {
        return lesson_detail_id;
    }

    public void setLesson_detail_id(String lesson_detail_id) {
        this.lesson_detail_id = lesson_detail_id;
    }



    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(String tutor_id) {
        this.tutor_id = tutor_id;
    }
}
