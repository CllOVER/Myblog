package cn.cllover.myblog.front.service.impl;

import cn.cllover.myblog.common.service.impl.BaseServiceimpl;
import cn.cllover.myblog.front.dao.CategoryMapper;
import cn.cllover.myblog.front.pojo.Category;
import cn.cllover.myblog.front.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service("CategoryService")
public class CategoryServiceimpl extends BaseServiceimpl<Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    private Logger logger = LoggerFactory.getLogger(CategoryServiceimpl.class);

    @Override
    public List<Category> findCatAndCount(Long userId) {
        return categoryMapper.findCatAndCount(userId);
    }

    public List<Category> findCats(Long userId) {
            Example example = new Example(Category.class);
            example.createCriteria().andCondition("cat_user_id=", userId);
            example.setOrderByClause("cat_id");
            return this.selectExample(example);
    }

    public Category findCatId(String catName,Long userId){

        Example example = new Example(Category.class);
        example.createCriteria().andCondition("cat_name=",catName).andCondition("cat_user_id=",userId);
        example.setOrderByClause("cat_id");
        List<Category> categories = this.selectExample(example);
        Category category = categories.get(0);
        return category;
    }

    @Override
    public Category findBycatName(String catName, Long catUserId) {
        return categoryMapper.findBycatName(catName, catUserId);
    }

    /*@Override
    public int findByCatName(String catName) {
        return categoryMapper.findByCatName(catName);
    }*/
}
