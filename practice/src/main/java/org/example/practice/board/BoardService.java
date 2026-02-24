package org.example.practice.board;

import lombok.RequiredArgsConstructor;
import org.example.practice.board.model.Board;
import org.example.practice.board.model.BoardDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void create(BoardDto.PostReq dto) {
        Board board = dto.toEntity();
        boardRepository.save(board);
    }
}
