package com.example.demo.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultsDTO {

    private long rockCount;

    private long metalCount;

    private long jazzCount;

    private long bluesCount;

    private long clasicoCount;
}
