package com.example.hippobookproject.controller.user;

import com.example.hippobookproject.service.user.UserNicknameDuplicateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserNicknameController {

    @Autowired
    private UserNicknameDuplicateService userNicknameDuplicateService;

    @PostMapping("/checkNickname")
    @ResponseBody
    public ResponseEntity<Boolean> confirmNickname(@RequestBody Map<String, String> requestBody){
        String userNickname = requestBody.get("userNickname");
        log.info("Nickname.................. ");
        log.info("userNickname: " + userNickname);

        if(userNickname == null || userNickname.trim().isEmpty()){
            log.info("userNickname : " + userNickname);
            return ResponseEntity.badRequest().build();
        }

        boolean result2 = !userNicknameDuplicateService.selectNickname(userNickname);

        return new ResponseEntity<>(result2, HttpStatus.OK);
    }
}
