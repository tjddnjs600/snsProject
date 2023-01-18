package com.sns.account.service.impl;

import com.sns.account.entity.AccountEntity;
import com.sns.account.repository.AccountRepository;
import com.sns.account.service.AccountService;
import com.sns.account.vo.AccountVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public String chkUsrId(String userId) {
        AccountEntity account = this.accountRepository.findById(userId).orElse(null);
        if(ObjectUtils.isNotEmpty(account)){
            return "no";
        }
        return "ok";
    }

    @Override
    public String chkUsrEmail(String email) {
        List<AccountEntity> list = this.accountRepository.findAll()
                .stream().filter(e -> email.equals(e.getUser_email())).collect(Collectors.toList());

        if(CollectionUtils.isEmpty(list)){
            return "ok";
        }

        return "no";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String accountInsert(AccountVo accountVo) throws InvocationTargetException, IllegalAccessException {

        AccountEntity account = new AccountEntity();
        BeanUtils.copyProperties(account, accountVo);

        AccountEntity save = this.accountRepository.save(account);
        if(ObjectUtils.isNotEmpty(save)){
            return "ok";
        }
        return "no";
    }

    @Override
    public String login(AccountVo accountVo) {
        return null;
    }
}
