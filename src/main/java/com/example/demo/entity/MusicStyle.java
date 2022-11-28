package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "music_style")
public class MusicStyle {

    @Id
    private Long id;

    private String style;

}
