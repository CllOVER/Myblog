package cn.cllover.myblog.front.dao;

import cn.cllover.myblog.common.MyMapper;
import cn.cllover.myblog.front.pojo.User;

public interface UserMapper extends MyMapper<User> {

    User selectBypassword(String userName);

    int updateByPrimaryKeyBySelective(User user);
}