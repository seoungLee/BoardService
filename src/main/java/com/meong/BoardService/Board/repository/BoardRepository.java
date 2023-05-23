package com.meong.BoardService.Board.repository;

import com.meong.BoardService.Board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
