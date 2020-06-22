package com.hac.todo.service.todo;


import com.hac.todo.config.auth.dto.SessionUser;
import com.hac.todo.domain.todo.TodoMapper;
import com.hac.todo.domain.user.UserMapper;
import com.hac.todo.web.dto.todo.TodoDetailRequestDto;
import com.hac.todo.web.dto.todo.TodoDetailResponseDto;
import com.hac.todo.web.dto.todo.TodoRequestDto;
import com.hac.todo.web.dto.todo.TodoListResponseDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class TodoService {

    private final TodoMapper todoMapper;
    private final UserMapper userMapper;

    @Transactional
    public int insertTodo(SessionUser user, TodoRequestDto todoRequestDto) {
        long id = getUserId(user.getEmail().toString());

        todoRequestDto = TodoRequestDto.builder()
                .title(todoRequestDto.getTitle())
                .id(id)
                .build();

        int affectRow = todoMapper.insertTodo(todoRequestDto);
        log.info("insertTodo affectRow :: {}", affectRow);

        return affectRow;
    }

    public Object getTodoList(SessionUser user, String state) {
        long id = getUserId(user.getEmail().toString());

        List<TodoListResponseDto> todoListResponseDtoList = todoMapper.selectTodoList()
            .stream()
            .filter(list -> list.getId() == id && "N".equals(list.getDelYn()) && state.equals(list.getState()))
            .collect(Collectors.toList());

        return todoListResponseDtoList;

    }

    @Transactional
    public int todoUpdateState(TodoRequestDto todoRequestDto) {
        return todoMapper.updateTodoState(todoRequestDto);
    }

    @Transactional
    public int deleteTodoState(TodoRequestDto todoRequestDto) {
        return todoMapper.deleteTodoState(todoRequestDto);
    }

    private long getUserId(String email) {
        return userMapper.selectUserInfo(email).getId();
    }

    public TodoDetailResponseDto getTodoDetailData(long no) {
        return todoMapper.selectTodoDetailData(no);
    }

    public int updateTodoDetail(TodoDetailRequestDto todoDetailRequestDto) {
//        todoDetailRequestDto.builder()
//                .startDate(todoDetailRequestDto.getStartDate())
//                .endDate(todoDetailRequestDto.getEndDate())
//                .startTime(todoDetailRequestDto.getStartTime())
//                .endTime(todoDetailRequestDto.getEndTime())
//                .build();

        todoDetailRequestDto.setStartDate(todoDetailRequestDto.getStartDate() + " "
                + todoDetailRequestDto.getStartTime() + ":00");
        todoDetailRequestDto.setEndDate(todoDetailRequestDto.getEndDate() + " "
                + todoDetailRequestDto.getEndTime() + ":00");

        return todoMapper.updateTodoDetail(todoDetailRequestDto);
    }
}
