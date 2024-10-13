package com.example.messageboard.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String text;

    @Column(name = "name", nullable = false)
    private String userName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date added;

    public Message() {}

    public Message(String text, String userName, Date added) {
        this.text = text;
        this.userName = userName;
        this.added = added;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }
}

