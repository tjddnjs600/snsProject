package com.sns.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "tb_comment")
@DynamicInsert
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comment_no;

    private int board_no;
    private String cmt_contant;
    private String user_id;
    private String cmt_image;
    private String like_cnt;
    private String regist_dt;
    private String update_dt;

    public CommentEntity() {}
}
