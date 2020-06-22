package com.hac.todo.web.dto.todo;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TodoDetailRequestDto {

    private long no;
    private String title;
    private String content;
    private String state;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;

//    @Builder
//    public TodoDetailRequestDto (long no, String title, String content, String state,
//                                 String startDate, String endDate, String startTime, String endTime) {
//
//        this.no = no;
//        this.title = title;
//        this.content = content;
//        this.state = state;
//        this.startDate = startDate + " " + startTime + ":00";
//        this.endDate = endDate + " " + endTime + ":00";
//    }
}
