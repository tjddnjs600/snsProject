package com.sns.account.service;

import com.sns.account.vo.AccountVo;

import java.lang.reflect.InvocationTargetException;

public interface AccountService {

    String chkUsrId(String userId);

    String chkUsrEmail(String email);

    String accountInsert(AccountVo accountVo) throws InvocationTargetException, IllegalAccessException;

    String login(AccountVo accountVo);
}
