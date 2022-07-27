package com.example.android.teacherclass;

import java.io.Serializable;

public class TeacherClass implements Serializable {
    private String lesson_detail_id;
    private String id;
    private String grade;
    private String name;
    private String subject;
    private String address;
    private String method;
    private String number;
    private String hour;
    private String fee;



    public String getLesson_detail_id() {
        return lesson_detail_id;
    }

    public void setLesson_detail_id(String lesson_detail_id) {
        this.lesson_detail_id = lesson_detail_id;
    }

    public String getGrade() {
        return grade;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TeacherClass{" +
                "lesson_detail_id='" + lesson_detail_id + '\'' +
                ", id='" + id + '\'' +
                ", grade='" + grade + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", address='" + address + '\'' +
                ", method='" + method + '\'' +
                ", number='" + number + '\'' +
                ", hour='" + hour + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }

    public TeacherClass(String lesson_detail_id, String id, String grade, String name, String subject, String address, String method, String number, String hour, String fee) {
        this.lesson_detail_id = lesson_detail_id;
        this.id = id;
        this.grade = grade;
        this.name = name;
        this.subject = subject;
        this.address = address;
        this.method = method;
        this.number = number;
        this.hour = hour;
        this.fee = fee;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
