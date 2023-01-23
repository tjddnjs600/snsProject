package com.sns.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_board")
@DynamicInsert
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_no;
    private String user_id;
    private String title;
    private String contant;
    private String image;
    private String view_cnt;
    private String like_cnt;
    private String regist_dt;
    private String update_dt;

    public BoardEntity() {}
}
