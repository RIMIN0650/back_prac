package org.example.practice.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.practice.board.model.Board;
import org.example.practice.board.model.BoardDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void create(BoardDto.PostReq dto) {
        Board board = dto.toEntity();
        boardRepository.save(board);
    }

    public List<BoardDto.Res> list() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardDto.Res> dtoList = new ArrayList<>();

        for (Board board : boardList) {
            dtoList.add(BoardDto.Res.from(board));
        }

        return dtoList;
    }

    public BoardDto.Res postDetail(Long idx) {
        Board board = boardRepository.findById(idx).orElseThrow(
                () -> new RuntimeException()
        );
        return BoardDto.Res.from(board);
    }

    @Transactional
    public void modify(Long idx, BoardDto.PostReq dto) {

        Board board = boardRepository.findById(idx)
                .orElseThrow(() -> new RuntimeException("게시글 없음")
        );

        board.update(dto.getTitle(), dto.getContents());

    }

    @Transactional
    public void delete(Long idx) {
        Board board = boardRepository.findById(idx)
                .orElseThrow(() -> new RuntimeException("게시글 없음")
        );

        boardRepository.delete(board);


    }
}
