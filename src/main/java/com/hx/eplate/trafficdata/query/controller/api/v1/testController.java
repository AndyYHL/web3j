package com.hx.eplate.trafficdata.query.controller.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018-03-27.
 */
@Controller
public class testController {
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "/index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "/login";
    }

    @GetMapping("/register")
    public String register(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "/register";
    }

    @GetMapping("/result")
    public String result(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "/result";
    }

    @GetMapping("/result_history")
    public String result_history(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "/result_history";
    }

    @GetMapping("/jsp_view")
    public ModelAndView jsp_view(HttpServletRequest request) {
        //逻辑处理
        ModelAndView modelAndView = new ModelAndView("Index");
        modelAndView.addObject("key", "hello world");
        return modelAndView;
    }
}
