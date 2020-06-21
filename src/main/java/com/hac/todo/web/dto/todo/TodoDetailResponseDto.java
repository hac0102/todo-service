package com.hac.todo.web.dto.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
public class TodoDetailResponseDto {

    private long no;
    private long id;
    private String title;
    private String content;
    private String state;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;

//    @Builder
//    public TodoDetailResponseDto(long no, long id, String title, String content, String state,
//                                 LocalDateTime startDate, LocalDateTime endDate,
//                                 LocalDateTime startTime, LocalDateTime endTime){
//
//        this.no = no;
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.state = state;
//        this.startDate = dateFomatter(startDate);
//        this.endDate = dateFomatter(endDate);
//        this.startTime = dateTimeFomatter(startTime);
//        this.endTime = dateTimeFomatter(endTime);
//    }
//
//    private LocalDate dateFomatter(LocalDateTime date) {
//        String strDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate returnDate = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        return returnDate;
//    }
//
//    private LocalDateTime dateTimeFomatter(LocalDateTime date) {
//        String strDate = date.format(DateTimeFormatter.ofPattern("HH:ss"));
//        LocalDateTime returnDate = LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern("HH:ss"));
//        return returnDate;
//    }
}
