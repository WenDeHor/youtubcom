package com.studio.youtubcom.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @Size(min = 0, max = 50)
    private String title;

    @Column(name = "anons")
    @Size(min = 0, max = 150)
    private String anons;

    @Column(name = "full_text")
    @Size(min = 0, max = 500)
    private String full_text;


    public Post() {
    }

    public Post(String title, String anons, String full_text) {
        this.title=title;
        this.anons=anons;
        this.full_text=full_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }


}
