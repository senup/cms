package com.xuetao.cms.dao;

import com.xuetao.cms.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO  extends JpaRepository<User,Integer>{
}
