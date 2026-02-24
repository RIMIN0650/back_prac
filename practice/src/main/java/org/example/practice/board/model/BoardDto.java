package org.example.practice.board.model;

import lombok.Setter;

public class BoardDto {

    @Setter
    public static class PostReq {
        private String title;
        private String contents;

        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .build();
        }
    }
}
