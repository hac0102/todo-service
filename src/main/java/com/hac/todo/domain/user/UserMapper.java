package com.hac.todo.domain.user;

import com.hac.todo.web.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    List<UserDto> selectUserList();

//    UserDto selectUserInfo(UserDto toEntity);
    Optional<UserDto> selectUserInfo(UserDto toEntity);

    long insertUserJoin(UserDto toEntity);

    void insertUserJoinHistory(UserDto toEntity);
}
