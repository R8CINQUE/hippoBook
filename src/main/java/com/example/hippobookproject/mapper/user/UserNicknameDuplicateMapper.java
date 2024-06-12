package com.example.hippobookproject.mapper.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserNicknameDuplicateMapper {

    int selectNickname(String userNickname);
}
