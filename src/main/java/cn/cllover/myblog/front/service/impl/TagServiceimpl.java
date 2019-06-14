package cn.cllover.myblog.front.service.impl;

import cn.cllover.myblog.common.service.impl.BaseServiceimpl;
import cn.cllover.myblog.front.dao.ArticleMapper;
import cn.cllover.myblog.front.dao.TagMapper;
import cn.cllover.myblog.front.pojo.Article;
import cn.cllover.myblog.front.pojo.Tag;
import cn.cllover.myblog.front.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("TagService")
public class TagServiceimpl extends BaseServiceimpl<Tag> implements TagService {

    private Logger logger = LoggerFactory.getLogger(TagServiceimpl.class);

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> findAndcount(Long userId) {
        return tagMapper.findAndcount(userId);
    }

    public List<Tag> findTags(Long userId){
            Example example = new Example(Tag.class);
            example.createCriteria().andCondition("tag_user_id=", userId);
            example.setOrderByClause("tag_id");
            return this.selectExample(example);
    }

    public Tag findTagId(String tagName,Long userId){

        Example example = new Example(Tag.class);
        example.createCriteria().andCondition("tag_name=",tagName).andCondition("tag_user_id=",userId);
        example.setOrderByClause("tag_id");
        List<Tag> tags = this.selectExample(example);
        Tag tagId = tags.get(0);
        return tagId;
    }

    @Override
    public boolean findByCounttagName(String tagName, Long tagUserId) {
        Long bytagName = tagMapper.findByCounttagName(tagName, tagUserId);
        return bytagName == 0;
    }

    @Override
    public Tag findBytagName(String tagName, Long tagUserId) {
        return tagMapper.findBytagName(tagName, tagUserId);
    }


}
