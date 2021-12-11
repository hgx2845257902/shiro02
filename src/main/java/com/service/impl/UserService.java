package com.service.impl;

import com.mapper.UserMapper;
import com.model.User;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer userid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public User selectUname(String username) {
        return userMapper.selectUname(username);
    }

    @Override
    public Set<String> selectRname(String rname) {
        return userMapper.selectRname(rname);
    }

    @Override
    public Set<String> selectPname(String pname) {
        return userMapper.selectPname(pname);
    }

    @Override
    public List<User> listAll(User user) {
        return userMapper.listAll(user);
    }
}
