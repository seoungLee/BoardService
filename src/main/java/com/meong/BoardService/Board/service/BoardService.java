package com.meong.BoardService.Board.service;

import com.meong.BoardService.Board.dto.BoardDTO;
import com.meong.BoardService.Board.entity.BoardEntity;
import com.meong.BoardService.Board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }
}
