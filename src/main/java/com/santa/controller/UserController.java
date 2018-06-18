package com.santa.controller;

import com.santa.converter.UserConverter;
import com.santa.dto.UserDto;
import com.santa.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/sigin")
    public HttpStatus sigIn(String login, String password) {
       if (userService.canLoginUser(login, password))  {
           return HttpStatus.OK;
       }
       return HttpStatus.BAD_REQUEST;
    }

    @PostMapping
    @RequestMapping("/create")
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(UserConverter.fromDto(userDto));
    }
}
