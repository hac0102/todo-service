package com.hac.todo.web.dto.user;

import lombok.*;

@ToString
@Getter
//@Setter
@NoArgsConstructor
public class UserDto {

    private long id;
    private String name;
    private String emailAddr;
    private String joinType;
    private String picture;
    private Role userRole;

    @Builder
    public UserDto(String name, String emailAddr, String picture, String joinType, Role userRole){
        this.name = name;
        this.emailAddr = emailAddr;
        this.picture = picture;
        this.joinType = joinType;
        this.userRole = userRole;
    }

    public UserDto update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.userRole.getKey();
    }

}
