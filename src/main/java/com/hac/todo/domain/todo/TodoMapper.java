package com.hac.todo.domain.todo;

import com.hac.todo.web.dto.todo.TodoDetailRequestDto;
import com.hac.todo.web.dto.todo.TodoDetailResponseDto;
import com.hac.todo.web.dto.todo.TodoRequestDto;
import com.hac.todo.web.dto.todo.TodoListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    int insertTodo(TodoRequestDto todoRequestDto);

    List<TodoListResponseDto> selectTodoList();

    int updateTodoState(TodoRequestDto todoRequestDto);

    int deleteTodoState(TodoRequestDto todoRequestDto);

    TodoDetailResponseDto selectTodoDetailData(long no);

    int updateTodoDetail(TodoDetailRequestDto todoDetailRequestDto);
}
