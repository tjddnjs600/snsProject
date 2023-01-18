package com.sns.account.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "tb_account")
public class AccountEntity {

    @Id
    private String user_id;
    private String user_pwd;
    private String user_email;
    private String user_class;
    private String regist_dt;
    private String update_dt;

    public AccountEntity() {}
}
