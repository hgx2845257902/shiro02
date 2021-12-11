package com.service;

import com.model.User;

import java.util.List;
import java.util.Set;

public interface IUserService {

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public User selectUname(String username);

    Set<String> selectRname(String rname);

    Set<String> selectPname(String pname);

    List<User> listAll(User user);

}
