package com.situ.chronicmange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {



    @GetMapping("/denglu")
    public String home(Model model){

        return "web/denglu";}
    @GetMapping("/index")
    public String test(Model model)
    {
        return "web/index";}
    @GetMapping("/web1")
    public String web(Model model)
    {
        return "web/web1";}
}



