package com.hy.springboard.controller;

import com.hy.springboard.dto.BoardRequestDto;
import com.hy.springboard.dto.BoardResponseDto;
import com.hy.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        boardService.createBoard(dto);
    }

    /**
     * 게시글 전체 조회 API
     *
     * @return 게시글 목록
     */
    @GetMapping
    public List<BoardResponseDto> getBoards(){
        return boardService.getBoards();

    }

    /**
     * 게시글 단건 조회 API
     *
     * @param id
     * @return 게시글
     */
    @GetMapping("/{id}")
    public BoardResponseDto getBoard(@PathVariable long id){
        return boardService.getBoard(id);
    }
}
