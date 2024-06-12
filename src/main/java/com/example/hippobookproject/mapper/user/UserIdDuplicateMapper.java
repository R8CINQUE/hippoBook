package com.example.hippobookproject.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Mapper
public interface UserIdDuplicateMapper {

    int selectId(String userLoginId);
}
