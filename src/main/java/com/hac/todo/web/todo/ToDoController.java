package com.hac.todo.web.todo;


import com.hac.todo.config.auth.LoginUser;
import com.hac.todo.config.auth.dto.SessionUser;
import com.hac.todo.service.todo.TodoService;
import com.hac.todo.web.dto.todo.TodoRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@RestController
@Slf4j
public class ToDoController {

    private final TodoService todoService;

    @PostMapping("/api/v1/todo")
    public ResponseEntity<?> insertTodo(@LoginUser SessionUser user,
                                     @RequestBody TodoRequestDto todoRequestDto){

        int affectRow = todoService.insertTodo(user, todoRequestDto);
        log.info("insertTodo affectRow :: {}", affectRow);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/v1/todo")
    public ResponseEntity<?> updateTodoState(@RequestBody TodoRequestDto todoRequestDto){
        int affectRow = todoService.todoUpdateState(todoRequestDto);
        log.info("updateTodoState affectRow :: {}", affectRow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/todo")
    public ResponseEntity<?> deleteTodoState(@RequestBody TodoRequestDto todoRequestDto){
        int affectRow = todoService.deleteTodoState(todoRequestDto);
        log.info("Delete TodoState affectRow :: {}", affectRow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/v1/todo/{no}")
    public ModelAndView getTodoDetailData(@PathVariable long no, ModelAndView mv){
        log.info("디디디ㅣ디딛테테테ㅔ텥이이이ㅣㅇㄹㄹ 값 :: ", no);
        mv.addObject("todoDetail", todoService.getTodoDetailData(no));
        mv.setViewName("main :: #todoDetailPopup");
        return mv;
    }
}
