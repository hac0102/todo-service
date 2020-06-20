package com.hac.todo.service.todo;


import com.hac.todo.config.auth.LoginUser;
import com.hac.todo.config.auth.dto.SessionUser;
import com.hac.todo.domain.todo.TodoMapper;
import com.hac.todo.domain.user.UserMapper;
import com.hac.todo.web.dto.todo.TodoAddRequestDto;
import com.hac.todo.web.dto.todo.TodoListResponseDto;
import com.hac.todo.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class TodoService {

    private final TodoMapper todoMapper;
    private final UserMapper userMapper;

    @Transactional
    public int insertTodo(SessionUser user, TodoAddRequestDto todoAddRequestDto) {
        long id = getUserId(user.getEmail().toString());

        todoAddRequestDto = TodoAddRequestDto.builder()
                .title(todoAddRequestDto.getTitle())
                .id(id)
                .build();

        int affectRow = todoMapper.insertTodo(todoAddRequestDto);
        log.info("insertTodo affectRow :: {}", affectRow);

        return affectRow;
    }

    public Object getTodoList(SessionUser user) {
        long id = getUserId(user.getEmail().toString());

        List<TodoListResponseDto> todoListResponseDtoList = todoMapper.selectTodoList()
            .stream()
            .filter(list -> list.getId() == id && "N".equals(list.getDelYn()) && "todo".equals(list.getState()))
            .collect(Collectors.toList());

        return todoListResponseDtoList;

    }

    private long getUserId(String email) {
        return userMapper.selectUserInfo(email).getId();

    }
}
