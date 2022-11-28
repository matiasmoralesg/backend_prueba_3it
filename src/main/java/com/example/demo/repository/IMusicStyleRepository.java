package com.example.demo.repository;

import com.example.demo.entity.MusicStyle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicStyleRepository extends JpaRepository<MusicStyle, Long> {

}
