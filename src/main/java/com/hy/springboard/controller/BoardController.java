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
     * @param dto (id,title,content,writer)
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


    /**
     * 게시글 수정 API
     *
     * @param dto (id,title,content,writer)
     * @return 1 : 수정 성공, 0 : 수정 실패
     */
    @PutMapping("/{id}")
    public int updateBoard(@PathVariable long id,@RequestBody BoardRequestDto dto){
        dto.setId(id);
        return boardService.updateBoard(dto);
    }

    /**
     * 게시글 삭제 API
     *
     * @param id
     * @return 1 : 수정 성공 / 0 : 수정 실패
     */
    @DeleteMapping("/{id}")
    public int deleteBoard(@PathVariable long id){
        return boardService.deleteBoard(id);
    }
}
