package com.meong.BoardService.Board.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHit;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;
}
