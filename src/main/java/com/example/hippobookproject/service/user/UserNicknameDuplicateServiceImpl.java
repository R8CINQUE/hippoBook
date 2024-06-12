package com.example.hippobookproject.service.user;

import com.example.hippobookproject.mapper.user.UserIdDuplicateMapper;
import com.example.hippobookproject.mapper.user.UserNicknameDuplicateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserNicknameDuplicateServiceImpl implements UserNicknameDuplicateService{

    @Autowired
    UserNicknameDuplicateMapper userNicknameDuplicateMapper;

    @Override
    public boolean selectNickname(String userNickname){
        log.info("Service :: selectId...........");
        int count = userNicknameDuplicateMapper.selectNickname(userNickname);
        return count > 0;
    }
}
