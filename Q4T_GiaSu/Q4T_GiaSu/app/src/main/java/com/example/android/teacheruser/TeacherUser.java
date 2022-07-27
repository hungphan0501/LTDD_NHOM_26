package com.example.android.teacheruser;

import com.example.android.spotlightTeacher;

import java.io.Serializable;
import java.util.List;

public class TeacherUser implements Serializable {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TeacherUser(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "TeacherUser{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
