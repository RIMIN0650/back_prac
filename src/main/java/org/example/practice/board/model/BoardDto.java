package org.example.practice.board.model;

import lombok.*;

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


    @Getter
    @Builder
    public static class Res {
        private Long idx;
        private String title;
        private String contents;

        public static Res from(Board entity) {
            return Res.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }

    }

}
