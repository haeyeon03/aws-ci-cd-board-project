package com.hy.springboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardRequestDto {

    private String title;
    private String content;
    private String writer;
}
