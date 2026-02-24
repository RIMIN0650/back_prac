package org.example.practice.board;

import lombok.RequiredArgsConstructor;
import org.example.practice.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @PostMapping("create")
    public ResponseEntity create(@RequestBody BoardDto.PostReq dto) {
        boardService.create(dto);
        return ResponseEntity.ok("게시물 등록 성공");
    }






}
