package com.hy.springboard.controller;

import com.hy.springboard.dto.BoardRequestDto;
import com.hy.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class PageController {

    private final BoardService boardService;

    /**
     * 게시글 목록 페이지
     *
     * @param model 뷰에 전달할 데이터
     * @return 게시글 목록 화면
     */
    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("boards", boardService.getBoards());
        return "board/list";
    }

    /**
     * 게시글 상세 페이지
     *
     * @param id    게시글 ID
     * @param model 뷰에 전달할 데이터
     * @return 게시글 상세 화면
     */
    @GetMapping("/{id}")
    public String detailPage(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.getBoard(id));
        return "board/detail";
    }

    /**
     * 게시글 작성 페이지
     *
     * @return 게시글 작성 화면
     */
    @GetMapping("/write")
    public String writePage() {
        return "board/write";
    }

    /**
     * 게시글 작성 처리
     *
     * @param dto (title, content, writer)
     * @return 저장 후 게시글 목록으로 리다이렉트
     */
    @PostMapping("/write")
    public String createBoard(BoardRequestDto dto) {
        boardService.createBoard(dto);
        return "redirect:/board";
    }

    /**
     * 게시글 수정 페이지
     *
     * @param id    게시글 ID
     * @param model 뷰에 전달할 데이터
     * @return 게시글 수정 화면
     */
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.getBoard(id));
        return "board/edit";
    }

    /**
     * 게시글 수정 처리
     *
     * @param dto (id, title, content, writer)
     * @return 수정 후 게시글 목록으로 리다이렉트
     */
    @PostMapping("/edit/{id}")
    public String updateBoard(BoardRequestDto dto) {
        boardService.updateBoard(dto);
        return "redirect:/board";
    }

    /**
     * 게시글 삭제 처리
     *
     * @param id 게시글 ID
     * @return 삭제 후 게시글 목록으로 리다이렉트
     */
    @PostMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "redirect:/board";
    }

}