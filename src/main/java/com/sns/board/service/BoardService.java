package com.sns.board.service;

import com.sns.board.entity.BoardEntity;

import java.util.List;

public interface BoardService {

    List<BoardEntity> selectBoard(String userId);

    BoardEntity insertBoard(BoardEntity boardEntity);
}
