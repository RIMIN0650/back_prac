package org.example.practice.board;

import lombok.RequiredArgsConstructor;
import org.example.practice.board.model.Board;
import org.example.practice.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = "http://localhost:5173"
)

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

    @GetMapping("/list")
    public ResponseEntity list() {
        List<BoardDto.Res> dto = boardService.list();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/detail/{idx}")
    public ResponseEntity detail(@PathVariable Long idx) {
        BoardDto.Res dto = boardService.postDetail(idx);
        return ResponseEntity.ok(dto);
    }
}
