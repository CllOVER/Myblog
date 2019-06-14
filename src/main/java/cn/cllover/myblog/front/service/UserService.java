package cn.cllover.myblog.front.service;

import cn.cllover.myblog.front.pojo.User;

import java.util.List;

public interface UserService  {


   User selectBypassword(String userName);

   List<User> findAll(Long userId);

   int updateByPrimaryKeyBySelective(User user);
}
