package com.hac.todo.web.user;

import com.hac.todo.service.user.UserService;
import com.hac.todo.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/userlist")
    public List<UserDto> getUserList(ModelAndView mv) throws Exception {
//        List<UserDto> list = userService.getUserList();
        return userService.getUserList();
    }
}
