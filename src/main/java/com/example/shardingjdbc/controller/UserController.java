package com.example.shardingjdbc.controller;

import com.example.shardingjdbc.entity.User;
import com.example.shardingjdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/save")
    public String save() {
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setCityId(i);
            user.setCreateTime(new Date());
            user.setSex(i % 2 == 0 ? 1 : 2);
            user.setPhone("11111111" + i);
            user.setEmail("xxxxx");
            user.setCreateTime(new Date());
            user.setPassword("eeeeeeeeeeee");
            userRepository.save(user);
        }

        return "success";
    }
}
