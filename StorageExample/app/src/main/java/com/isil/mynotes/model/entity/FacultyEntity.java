package com.isil.mynotes.model.entity;

import java.io.Serializable;

/**
 * Created by eduardomedina on 19/10/16.
 */
public class FacultyEntity implements Serializable {
    private int id;
    private String title;
    private String photo;


    public FacultyEntity() {
    }

    public FacultyEntity(String title, String photo) {
        this.title = title;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
