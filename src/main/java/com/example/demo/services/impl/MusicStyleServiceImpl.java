package com.example.demo.services.impl;

import com.example.demo.entity.MusicStyle;
import com.example.demo.repository.IMusicStyleRepository;
import com.example.demo.services.IMusicStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicStyleServiceImpl implements IMusicStyleService {

    @Autowired
    private IMusicStyleRepository iMusicStyleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MusicStyle> findAll() {
        return iMusicStyleRepository.findAll();
    }
}
