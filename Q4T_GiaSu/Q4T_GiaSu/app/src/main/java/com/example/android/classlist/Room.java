package com.example.android.classlist;

import java.io.Serializable;

public class Room implements Serializable {
    private String lesson_detail_id;
    private String user_id;
    private String grade;
    private String subject;
    private String fee;
    private String address;
    private String method;

    public String getLesson_detail_id() {
        return lesson_detail_id;
    }

    public void setLesson_detail_id(String lesson_detail_id) {
        this.lesson_detail_id = lesson_detail_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "lesson_detail_id='" + lesson_detail_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", grade='" + grade + '\'' +
                ", subject='" + subject + '\'' +
                ", fee='" + fee + '\'' +
                ", address='" + address + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public Room(String lesson_detail_id, String user_id, String grade, String subject, String fee, String address, String method) {
        this.lesson_detail_id = lesson_detail_id;
        this.user_id = user_id;
        this.grade = grade;
        this.subject = subject;
        this.fee = fee;
        this.address = address;
        this.method = method;
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

}