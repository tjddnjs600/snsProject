package com.sns.board.service.impl;

import com.sns.board.entity.CommentEntity;
import com.sns.board.repository.CommentRepository;
import com.sns.board.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Override
    public List<CommentEntity> selectComment(int boardNo) {
        return this.commentRepository.findAll().stream()
                .filter(cm -> boardNo == cm.getBoard_no()).collect(Collectors.toList());
    }

    @Override
    public CommentEntity insertComment(CommentEntity commentEntity) {
        return this.commentRepository.save(commentEntity);
    }
}
