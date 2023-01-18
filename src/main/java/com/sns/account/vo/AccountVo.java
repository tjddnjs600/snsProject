package com.sns.account.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountVo {
    private String user_id;
    private String user_pwd;
    private String user_email;
    private String user_class;
    private String regist_dt;
    private String update_dt;
}
