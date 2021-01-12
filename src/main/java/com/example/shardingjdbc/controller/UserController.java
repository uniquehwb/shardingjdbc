package com.example.shardingjdbc.controller;

import com.example.shardingjdbc.entity.User;
import com.example.shardingjdbc.mapper.UserMapper;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Resource
    SnowflakeShardingKeyGenerator userKeyGenerator;

    @RequestMapping("/user/save")
    @ResponseBody
    public String save() {
        for (int i = 0; i < 50; i++) {
            Long id = (Long)userKeyGenerator.generateKey();
            User user = new User();
            user.setId(id);
            user.setName("test" + i);
            user.setCityId(i);
            user.setCreateTime(new Date());
            user.setSex(i % 2 == 0 ? 1 : 2);
            user.setPhone("11111111" + i);
            user.setEmail("xxxxx");
            user.setCreateTime(new Date());
            user.setPassword("eeeeeeeeeeee");
            userMapper.save(user);
        }

        return "success";
    }

    @RequestMapping("/user/get/{id}")
    @ResponseBody
    public User get(@PathVariable Long id) {
        User user = userMapper.get(id);
        return user;
    }
}
