package cn.cllover.myblog.common.service.impl;

import cn.cllover.myblog.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public abstract class BaseServiceimpl<T> implements BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(T entry) {
        return mapper.insert(entry);
    }

    @Override
    public int deleteByKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int batchDelete(List<String> list, String properties, Class<T> clazz) {
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        return mapper.deleteByExample(example);
    }

    @Override
    public int update(T entry) {
        return mapper.updateByPrimaryKey(entry);
    }

    @Override
    public int updateSelective(T entry) {
        return mapper.updateByPrimaryKeySelective(entry);
    }

    @Override
    public List<T> selectExample(Object example) {
        return mapper.selectByExample(example);
    }
}
