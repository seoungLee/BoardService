package com.meong.BoardService.Board.Controller;

import com.meong.BoardService.Board.dto.BoardDTO;
import com.meong.BoardService.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final BoardService boardService;

    /*@GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "index";
    }*/

    @GetMapping("/")
    public String paging(@PageableDefault(page = 1) Pageable pageable, Model model) {
        Page<BoardDTO> boardList = boardService.paging(pageable);
    }
}
