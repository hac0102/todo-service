package com.hac.todo.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
@Slf4j
public class CustomErrorController implements ErrorController {

    private final String VIEW_PATH = "/error/";

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request, ModelAndView mv) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        log.info("request status_code :: {}", status);
        if(status != null){
            int statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()){
                mv.setViewName(VIEW_PATH + "404");
                return mv;
            }

            if(statusCode == HttpStatus.FORBIDDEN.value()){
                mv.setViewName(VIEW_PATH + "500");
                return mv;
            }
        }

        mv.setViewName(VIEW_PATH + "error");
        return mv;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
