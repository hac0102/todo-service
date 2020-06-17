package com.hac.todo.web;

import com.hac.todo.config.auth.LoginUser;
import com.hac.todo.config.auth.dto.SessionUser;
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

    @GetMapping("/")
    public ModelAndView index(ModelAndView mv, @LoginUser SessionUser user) throws Exception {
//        log.info("user name :: {}", user.getName());
//        log.info("user email :: {}", user.getEmail());
//        log.info("user picture :: {}", user.getPicture());

        if(user == null){
            mv.setViewName("login");
            return mv;
        }


        mv.addObject("userInfo", user);
        mv.setViewName("main");

        return mv;
    }
}
