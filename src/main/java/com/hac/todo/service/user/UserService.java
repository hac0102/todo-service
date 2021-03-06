package com.hac.todo.service.user;

import com.hac.todo.domain.user.UserMapper;
import com.hac.todo.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;

    public List<UserDto> getUserList() {
        return userMapper.selectUserList();
    }
}
