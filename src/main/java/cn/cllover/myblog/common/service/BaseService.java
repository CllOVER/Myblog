package cn.cllover.myblog.common.service;

import org.springframework.stereotype.Service;
import java.util.List;

/*
* 基础公共业务接口
* */
@Service
public interface BaseService<T> {

    //查询所有信息
    List<T> selectAll();

    //根据主键查询
    T selectByKey(Object key);

    //保存
    int save(T entry);

    //根据主键删除
    int deleteByKey(Object key);

    //批量删除
    int batchDelete(List<String> list ,String properties, Class<T> clazz);

    //修改
    int update(T entry);

    //选择性修改
    int updateSelective(T entry);

    //条件查询
    List<T> selectExample(Object example);
}
