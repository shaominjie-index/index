package com.ianji.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserDao userDao;

    private volatile int num = 0;
    @GetMapping(value = "get")
    public Object getUser(){
        return userDao.findAll();
    }

    @GetMapping(value = "add")
    public Object addUser(){
        User user = new User();
        user.setName("admin"+num);
        num++;
        user.setEmail("index_shao@163.com");
        user.setPassword(user.getName());
        userDao.save(user);
        return userDao.findAll();
    }
    @GetMapping(value = "findUsersByNameAndEmail")
    public Object findUsersByNameAndEmail(){
        User user = new User();
        List<User> userList =
                userDao.findAllByNameContainingAndEmail(
//                userDao.findUsersByNameAndEmail(
                        "admin%",
                        "index_shao@163.com");
        return userList;
    }
    @GetMapping(value = "getByNameFuzzy")
    public Object getByNameFuzzy(){
        List<User> userList =
                userDao.getByNameFuzzy(
                        "admin");
        return userList;
    }
    @GetMapping(value = "queryByUsernameLike")
    public Object queryByUsernameLike(){
//        Pageable pageable = Pageable.unpaged();
        Pageable pageable = PageRequest.of(0,5);
        Page<User> userPage = userDao.getByNameFuzzy("admin",pageable);

        Page<User> userList =
            userDao.queryByUsernameLike(
                    "admin",pageable);
        System.out.println(userList.getTotalPages());
        return userList;
    }
}
