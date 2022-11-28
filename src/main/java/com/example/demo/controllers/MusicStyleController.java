package com.example.demo.controllers;

import com.example.demo.entity.MusicStyle;
import com.example.demo.services.IMusicStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/musicStyles")
public class MusicStyleController {

    @Autowired
    private IMusicStyleService iMusicStyleService;

    @GetMapping("/list")
    public List<MusicStyle> getMusicSyles(){
        return iMusicStyleService.findAll();
    }

}
