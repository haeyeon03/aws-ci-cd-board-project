package com.hy.springboard.service;

import com.hy.springboard.dto.BoardRequestDto;
import com.hy.springboard.entity.Board;
import com.hy.springboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 게시글 생성 서비스 로직
     *
     * @param dto (title,content,writer)
     */
    public void createdBoard(BoardRequestDto dto){
        Board board = new Board(
                dto.getTitle(),
                dto.getContent(),
                dto.getWriter()
        );

        boardRepository.save(board);
    }
}
