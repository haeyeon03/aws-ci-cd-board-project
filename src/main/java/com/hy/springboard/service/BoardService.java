package com.hy.springboard.service;

import com.hy.springboard.dto.BoardRequestDto;
import com.hy.springboard.dto.BoardResponseDto;
import com.hy.springboard.entity.Board;
import com.hy.springboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 게시글 생성 서비스 로직
     *
     * @param dto (title,content,writer)
     */
    public void createBoard(BoardRequestDto dto){
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

    /**
     * 게시글 단건 조회 서비스 로직
     *
     * @param id
     * @return 게시글
     */
    public BoardResponseDto getBoard(Long id) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글이 없습니다."));
        BoardResponseDto dto = new BoardResponseDto(board);
        return dto;
    }
}
