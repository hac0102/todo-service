package com.hac.todo.web.dto.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TodoListResponseDto {

    private long no;
    private long id;
    private String title;
    private String content;
    private String delYn;

    @Builder
    public TodoListResponseDto(long no, long id, String title, String content, String delYn){
        this.no = no;
        this.id = id;
        this.title = title;
        this.content = content;
        this.delYn = delYn;
    }



}
