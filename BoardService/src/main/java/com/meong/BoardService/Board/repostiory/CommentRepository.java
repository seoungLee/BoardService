package com.meong.BoardService.Board.repostiory;

import com.meong.BoardService.Board.entity.BoardEntity;
import com.meong.BoardService.Board.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByBoardEntityOrderByIdDesc(BoardEntity boardEntity);
}
