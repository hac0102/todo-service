package com.hac.todo.web.todo;


import com.hac.todo.config.auth.LoginUser;
import com.hac.todo.config.auth.dto.SessionUser;
import com.hac.todo.service.todo.TodoService;
import com.hac.todo.web.dto.todo.TodoAddRequestDto;
import com.hac.todo.web.dto.todo.TodoListResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequiredArgsConstructor
@RestController
@Slf4j
public class ToDoController {

    private final TodoService todoService;

    @PostMapping("/api/v1/todo")
    public ResponseEntity<?> insertTodo(@LoginUser SessionUser user,
                                     @RequestBody TodoAddRequestDto todoAddRequestDto,
                                     ModelAndView mv){

        int affectRow = todoService.insertTodo(user, todoAddRequestDto);
        log.info("insertTodo affectRow :: {}", affectRow);

      return new ResponseEntity<>(HttpStatus.OK);
    }
}
