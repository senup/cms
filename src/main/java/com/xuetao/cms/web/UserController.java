package com.xuetao.cms.web;

import com.xuetao.cms.pojo.User;
import com.xuetao.cms.service.UserService;
import com.xuetao.cms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Map list(@RequestParam(value = "start", defaultValue = "0") int start,
                    @RequestParam(value = "size", defaultValue = "20") int size) throws Exception {
        start = start<0?0:start;
        Page page = userService.list(start, size);
        Map<Object, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",20);
        map.put("data",page.getContent());
//        Result result = new Result(0, "", page.getSize(), page.getContent());
        return map;

    }
    @GetMapping("/user")
    public Result listAll(){
        List<User> list = userService.list();
        Result result = new Result(0, "", 0, list);
        return result;
    }

}
