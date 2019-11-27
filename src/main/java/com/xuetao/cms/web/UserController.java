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
    public Result list(@RequestParam(value = "start", defaultValue = "0") int start,
                    @RequestParam(value = "size", defaultValue = "20") int size) throws Exception {
        start = start<1?1:start;
        Page page = userService.list(start-1, size);
        Result result = new Result(0, "", (int) page.getTotalElements(), page.getContent());
        return result;

    }


}
