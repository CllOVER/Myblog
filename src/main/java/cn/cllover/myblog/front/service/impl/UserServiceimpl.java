package cn.cllover.myblog.front.service.impl;


import cn.cllover.myblog.common.service.impl.BaseServiceimpl;
import cn.cllover.myblog.front.dao.UserMapper;
import cn.cllover.myblog.front.pojo.User;
import cn.cllover.myblog.front.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("UserService")
public class UserServiceimpl extends BaseServiceimpl<User> implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;


    //查询
    @Override
    public User selectBypassword(String userName){
        User user = userMapper.selectBypassword(userName);
        return userMapper.selectBypassword(userName);
    }

    @Override
    public List<User> findAll(Long userId) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("user_id=", userId);
        example.setOrderByClause("user_id");
        return this.selectExample(example);
    }

    @Override
    public int updateByPrimaryKeyBySelective(User user) {
        return userMapper.updateByPrimaryKeyBySelective(user );
    }


}
