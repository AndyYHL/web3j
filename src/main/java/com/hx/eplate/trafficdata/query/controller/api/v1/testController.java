package com.hx.eplate.trafficdata.query.controller.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018-03-27.
 */
@Controller
public class testController {
    @GetMapping("/index")
    public String test(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "/index";
    }
}
