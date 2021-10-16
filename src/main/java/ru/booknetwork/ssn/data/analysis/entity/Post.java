package ru.booknetwork.ssn.data.analysis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class Post {
    public Post() {
    }

    @JsonProperty("text")
    private String text;

    @JsonProperty("date")
    private Timestamp date;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("id")
    private int id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
