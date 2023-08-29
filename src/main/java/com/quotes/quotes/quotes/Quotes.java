package com.quotes.quotes.quotes;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Quotes {

    @Id
    @GeneratedValue
    private long id;
    private String author;
    private String text;
    private String source;
    private Date dateCreation;
    private Date dateUpdate;

    public Quotes(String author, String text,
                  String source) {
        this.author = author;
        this.text = text;
        this.source = source;
    }

    public Quotes(String author, String text,
                  String source, Date dateCreation, Date dateUpdate) {
        this.author = author;
        this.text = text;
        this.source = source;
    }

    public Quotes() {
    }


    @PrePersist
    protected void onCreate() {
        this.dateCreation = new Date();
        this.dateUpdate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dateUpdate = new Date();
    }

    public long getId() {
        return this.id;
    }


    public String getAuthor() {
        return this.author;
    }

    public String getText() {
        return this.text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", dateCreation=" + dateCreation +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
