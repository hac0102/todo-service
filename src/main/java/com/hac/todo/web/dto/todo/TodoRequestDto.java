package com.hac.todo.web.dto.todo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class TodoRequestDto {

    /** 사용자 id 키값 */
    private long id;
    private long no;
    /** todo 제목*/
    private String title;
    /** todo 내용*/
    private String content;
    private String state;

    @Builder
    public TodoRequestDto(String title, String content, long id, long no, String state){
        this.title = title;
        this.content = content;
        this.id = id;
        this.no = no;
        this.state = state;
    }

    public Todo toEntity(){
        return Todo.builder()
                .content(content)
                .title(title)
                .build();
    }
}
