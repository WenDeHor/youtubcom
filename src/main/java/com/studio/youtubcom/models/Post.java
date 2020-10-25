package com.studio.youtubcom.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @Size(min = 0, max = 100)
    private String title;

    @Column(name = "video")
    @Size(min = 0, max = 200)
    private String video;

    @Column(name = "anons")
    @Size(min = 0, max = 200)
    private String anons;

    @Column(name = "full_text")
    @Size(min = 0, max = 1000)
    private String full_text;


    public Post(Long id, @Size(min = 0, max = 100) String title, @Size(min = 0, max = 200) String video, @Size(min = 0, max = 200) String anons, @Size(min = 0, max = 1000) String full_text) {
        this.id = id;
        this.title = title;
        this.video = video;
        this.anons = anons;
        this.full_text = full_text;
    }
}
