package com.isil.mynotes.model.entity;

import java.io.Serializable;

/**
 * Created by Profesor on 19/10/2016.
 */
public class GradeEntity implements Serializable{
    private int id;
    private String course;
    private int grade;
    private int userId;
    private String photo;

    public GradeEntity() {
    }

    public GradeEntity(String course, int grade, int userId, String photo) {
        this.course = course;
        this.grade = grade;
        this.userId = userId;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
