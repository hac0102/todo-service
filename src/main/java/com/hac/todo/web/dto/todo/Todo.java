package com.hac.todo.web.dto.todo;

import com.hac.todo.web.dto.user.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Todo {

    private long no;
    private UserDto userDto;
    private String title;
    private String content;
    private LocalDateTime frstRegDate;
    private LocalDateTime lastChgDate;

    @Builder
    public Todo(UserDto userDto, String title, String content, LocalDateTime frstRegDate, LocalDateTime lastChgDate){
//        this.no = no;
        this.userDto = userDto;
        this.content = content;
        this.title = title;
        this.frstRegDate = LocalDateTime.now();
        this.lastChgDate = LocalDateTime.now();
    }



}
