package com.pactera.controller;

import com.pactera.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomController {

    @Autowired
    WelcomeService welcomeService;

    @GetMapping("/index")
    public String welcome(Model m) {
        int port = welcomeService.getPort();
        System.out.println("端口号是: " + port);
        m.addAttribute("port", port);
        return "welcome";
    }

    /* 默认跳转到/index路径 */
    @RequestMapping(value="/")
    public String default_url() {
        return "redirect:/index";
    }

}