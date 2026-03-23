package hy.springboard.board.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardViewController {

    @GetMapping
    public String listPage() {
        return "board/list";
    }

    @GetMapping("/{id}")
    public String detailPage() {
        return "board/detail";
    }

    @GetMapping("/write")
    public String writePage() {
        return "board/write";
    }

    @GetMapping("/edit/{id}")
    public String editPage() {
        return "board/edit";
    }

}