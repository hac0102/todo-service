package com.hac.todo.web.dto.todo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class TodoAddRequestDto {

    /** todo 제목*/
    private String title;
    /** todo 내용*/
    private String content;
    /** 사용자 id 키값 */
    private long id;

    @Builder
    public TodoAddRequestDto(String title, String content, long id){
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public Todo toEntity(){
        return Todo.builder()
                .content(content)
                .title(title)
                .build();
    }
}
