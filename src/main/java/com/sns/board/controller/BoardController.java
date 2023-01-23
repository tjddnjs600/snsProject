package com.sns.board.controller;

import com.sns.board.entity.BoardEntity;
import com.sns.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    @GetMapping("/selectBoard/{userId}")
    public List<BoardEntity> selectBoard(@PathVariable String userId){
        return this.boardService.selectBoard(userId);
    }

    @PostMapping(value = "/insertBoard"
            , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertBoard(@RequestBody BoardEntity boardEntity){

        BoardEntity res = this.boardService.insertBoard(boardEntity);

        if(ObjectUtils.isEmpty(res)){
            return "fail";
        } else {
            return "ok";
        }
    }
}
