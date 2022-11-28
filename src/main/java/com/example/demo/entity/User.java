package com.example.demo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User  {

    @Id
    @Email
    @NotBlank
    private String email;

    @OneToOne
    @JoinColumn(name = "music_style_id")
    @NotNull
    private MusicStyle musicStyle;

}
