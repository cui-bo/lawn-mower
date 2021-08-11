package com.bo.mower.lawnmover.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(path = "/")
    public ModelAndView home() {
        return new ModelAndView("redirect:" + "/swagger-ui/index.html");
    }
}
