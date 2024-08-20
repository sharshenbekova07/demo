package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;

    @Column(name = "text_message")
    private String textMessage;

    @Column(name = "date_create")
    private Timestamp dateCreate;

    @ManyToOne
    @JoinColumn(name ="author_id",referencedColumnName = "id")
    private  User authorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public User getAuthorId() {
        return authorId;
    }

    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }
}
