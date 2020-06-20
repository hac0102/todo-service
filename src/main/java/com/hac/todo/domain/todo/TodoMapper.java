package com.hac.todo.domain.todo;

import com.hac.todo.web.dto.todo.TodoAddRequestDto;
import com.hac.todo.web.dto.todo.TodoListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    int insertTodo(TodoAddRequestDto todoAddRequestDto);

    List<TodoListResponseDto> selectTodoList();
}
