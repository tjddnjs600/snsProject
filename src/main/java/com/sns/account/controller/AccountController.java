package com.sns.account.controller;

import com.sns.account.service.AccountService;
import com.sns.account.vo.AccountVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @PostMapping("/chkId")
    public String chkUsrId(@RequestBody String userId){
        return this.accountService.chkUsrId(userId);
    }

    @PostMapping("/chkEmail")
    public String chkUsrEmail(@RequestBody String email){
        return this.accountService.chkUsrEmail(email);
    }

    @PostMapping(value = "/insertUser"
            , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> accountInsert(@RequestBody AccountVo accountVo) throws InvocationTargetException, IllegalAccessException {
        String res = this.accountService.accountInsert(accountVo);
        if("ok".equals(res)){
            /*HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/account/chkId"));
            return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);*/
            return new ResponseEntity<String>("ok", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
        }
    }
}
