package com.sns.board.service.impl;

import com.sns.board.entity.BoardEntity;
import com.sns.board.repository.BoardRepository;
import com.sns.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Override
    public List<BoardEntity> selectBoard(String userId) {
        return this.boardRepository.findAll().stream()
                .filter(nm -> userId.equals(nm.getUser_id())).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BoardEntity insertBoard(BoardEntity boardEntity) {
        /*if(StringUtils.isEmpty(boardEntity.getRegist_dt())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String today = LocalDateTime.now().format(formatter);

            boardEntity.setRegist_dt(today);
            boardEntity.setUpdate_dt(today);
        }*/
        return this.boardRepository.save(boardEntity);
    }
}
