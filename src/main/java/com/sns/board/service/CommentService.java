package com.sns.board.service;

import com.sns.board.entity.CommentEntity;

import java.util.List;

public interface CommentService {

    List<CommentEntity> selectComment(int boardNo);

    CommentEntity insertComment(CommentEntity commentEntity);
}
