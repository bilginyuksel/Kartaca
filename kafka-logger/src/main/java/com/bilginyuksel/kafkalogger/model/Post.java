package com.bilginyuksel.kafkalogger.model;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    private int id;
    private String note, place;
    private String photo_url; // Maybe i don't need it
    private User created_by;
    private Date created_time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", place='" + place + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", created_by=" + created_by +
                ", created_time=" + created_time +
                '}';
    }
}
