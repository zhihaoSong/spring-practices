package com.szh.controller;
import com.szh.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("view")
public class UserController {

    @RequestMapping(value = "/user", method = {RequestMethod.GET})
    public ModelAndView getUser() {
        User user = new User();
        user.setId(1000);
        user.setName("szh");
        user.setEmail("szh@qq.com");
        ModelAndView view = new ModelAndView("userInfo");
        view.addObject("user", user);
        return view;
    }
}