package com.hy.springboard.controller;

import com.hy.springboard.dto.BoardRequestDto;
import com.hy.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 생성 API
     *
     * @param dto (title,content,writer)
     */
    @PostMapping
    public void createBoard(@RequestBody  BoardRequestDto dto) {
        boardService.createdBoard(dto);
    }

}
