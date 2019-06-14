package cn.cllover.myblog.front.service;

import cn.cllover.myblog.front.pojo.Category;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface CategoryService {

    List<Category> findCatAndCount(Long userId);

    List<Category> findCats(Long userId);

    Category findCatId(String catName,Long userId);

    Category findBycatName( String catName,Long catUserId);
}
