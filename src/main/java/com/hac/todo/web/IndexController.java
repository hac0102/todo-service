package com.hac.todo.web;

import com.hac.todo.config.auth.LoginUser;
import com.hac.todo.config.auth.dto.SessionUser;
import com.hac.todo.service.todo.TodoService;
import com.hac.todo.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@Slf4j
public class IndexController {

    private final HttpSession httpSession;
    private final TodoService todoService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mv, @LoginUser SessionUser user) throws Exception {

        if(user == null){
            mv.setViewName("login");
            return mv;
        }
        mv.addObject("todoList", todoService.getTodoList(user, "todo"));
        mv.addObject("doingList", todoService.getTodoList(user, "doing"));
        mv.addObject("doneList", todoService.getTodoList(user, "done"));
        mv.addObject("userInfo", user);
        mv.setViewName("main");

        return mv;
    }

    @GetMapping("/logout2")
    public ModelAndView logout(ModelAndView mv, @LoginUser SessionUser user){
        log.info("로그아웃 name :: {}", user == null ? "null" : user.getName());
        log.info("로그아웃 email :: {}", user == null ? "null" : user.getEmail());

//        httpSession.setAttribute("user", null);
        httpSession.removeAttribute("user");
        user = null;
        mv.setViewName("login");
        return mv;
    }


}
