package com.sns.board.controller;

import com.sns.board.entity.CommentEntity;
import com.sns.board.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/comment")
public class CommnetController {

    private CommentService commentService;

    @GetMapping("/selectComment/{boardNo}")
    public List<CommentEntity> selectComment(@PathVariable String boardNo){
        return this.commentService.selectComment(Integer.parseInt(boardNo));
    }

    @PostMapping(value = "/insertComment"
            , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertComment(@RequestBody CommentEntity commentEntity){
        CommentEntity res = this.commentService.insertComment(commentEntity);
        if(ObjectUtils.isEmpty(res))
            return "fail";
        else
            return "ok";
    }
}
