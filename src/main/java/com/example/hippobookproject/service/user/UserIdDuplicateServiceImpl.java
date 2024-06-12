package com.example.hippobookproject.service.user;

import com.example.hippobookproject.mapper.user.UserIdDuplicateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserIdDuplicateServiceImpl implements UserIdDuplicateService{

    @Autowired
    UserIdDuplicateMapper userIdDuplicateMapper;

    @Override
    public boolean selectId(String userLoginId){
        log.info("Service :: selectId...........");
        int count = userIdDuplicateMapper.selectId(userLoginId);
        return count > 0;
    }
}
