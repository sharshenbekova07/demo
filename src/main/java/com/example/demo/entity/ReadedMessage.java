package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "readed_messages")
public class ReadedMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  Boolean readed=false;

    @ManyToOne
    @JoinColumn(name = "massage_id")
    private  Message massageId;

    @ManyToOne
    @JoinColumn(name = "recipient_id",referencedColumnName = "id")
    private User recipientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    public Message getMassageId() {
        return massageId;
    }

    public void setMassageId(Message massageId) {
        this.massageId = massageId;
    }

    public User getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(User recipientId) {
        this.recipientId = recipientId;
    }
}
