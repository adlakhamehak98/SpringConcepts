package com.thymeleaf.thymeleafDemo.controller;

import com.thymeleaf.thymeleafDemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@RequestMapping("/")
@Controller
public class MyController {

    //Question 1: Create an external JS file and use it to show an alert on click of a button.
    @GetMapping("sayHello")
    public ModelAndView sayHello() {
        ModelAndView modelAndView = new ModelAndView("hello");
        //modelAndView.addObject("name", "Hello World!!!!!");
        return modelAndView;
    }

    //Question 5: Show different custom greeting message based on the type of user.
    //For example, if the user is of type admin=true then show "Hello Admin" message on Page
    // else show "Hello User" basis on isAdmin attribute value passed in model data.
    @RequestMapping("isAdmin")
    public String isAdmin(){
        ModelAndView modelAndView = new ModelAndView("admin");
        return "admin";
    }

    //Question 7: Make a web page to show server time using ajax call.
    @GetMapping("serverTime")
    public String serverTime(){
        ModelAndView modelAndView = new ModelAndView("serverTime");
        return "serverTime";
    }
    //Question 7: Make a web page to show server time using ajax call.
    @GetMapping("getTime")
    @ResponseBody
    public String getTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
