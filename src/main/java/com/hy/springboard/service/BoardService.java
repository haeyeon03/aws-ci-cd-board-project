package com.hy.springboard.service;

import com.hy.springboard.dto.BoardRequestDto;
import com.hy.springboard.dto.BoardResponseDto;
import com.hy.springboard.entity.Board;
import com.hy.springboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 게시글 전체 조회 서비스 로직
     *
     * @return 게시글 목록
     */
    public List<BoardResponseDto> getBoards() {
        List<Board> boards = boardRepository.findAll();

        List<BoardResponseDto> list = new ArrayList<>();

        for (Board board : boards){
            BoardResponseDto dto = new BoardResponseDto(board);
            list.add(dto);
        }

        return list;
    }
}
