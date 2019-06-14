package cn.cllover.myblog.front.dao;

import cn.cllover.myblog.common.MyMapper;
import cn.cllover.myblog.front.pojo.Category;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface CategoryMapper extends MyMapper<Category> {

    List<Category> findCatAndCount(Long userId);

    void saveAll(Category record);

    Category findBycatName(@Param("catName") String catName, @Param("catUserId")Long catUserId);
}