package cn.cllover.myblog.front.service.impl;

import cn.cllover.myblog.common.entries.AddBlog;
import cn.cllover.myblog.common.service.impl.BaseServiceimpl;
import cn.cllover.myblog.front.dao.ArticleMapper;
import cn.cllover.myblog.front.dao.CategoryMapper;
import cn.cllover.myblog.front.dao.TagMapper;
import cn.cllover.myblog.front.pojo.*;
import cn.cllover.myblog.front.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("ArticleService")
public class ArticleServiceimpl extends BaseServiceimpl<Article> implements ArticleService {

    private Logger logger = LoggerFactory.getLogger(ArticleServiceimpl.class);

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagArtCountService tagArtCountService;
    @Autowired
    private CatArtCountService catArtCountService;

    @Override
    public void saveAll(AddBlog addBlog) {

        //标签
        Tag tag = new Tag();
        tag.setTagName(addBlog.getTagName());
        tag.setTagUserId(addBlog.getUserId());
        tagMapper.saveAll(tag);
        //反设置标签给博客
        Tag tagId = tagService.findTagId(addBlog.getTagName(),addBlog.getUserId());

        //分类
        Category category = new Category();
        category.setCatName(addBlog.getCatName());
        category.setCatUserId(addBlog.getUserId());
        categoryMapper.saveAll(category);
        Category catId = categoryService.findCatId(addBlog.getCatName(),addBlog.getUserId());

        //博客
        Article article = new Article();
        article.setArtContent(addBlog.getArtContent());
        article.setArtTitle(addBlog.getArtTitle());
        article.setArtTop(addBlog.getArtTop());
        article.setArtPoint(addBlog.getArtPoint());
        article.setArtDesc(addBlog.getArtDesc());
        article.setArtOpenPrivate(addBlog.getArtOpenPrivate());
        article.setArtStatus(addBlog.getArtStatus());
        article.setArtWritedate(new Date());
        article.setArtUserId(addBlog.getUserId());
        article.setArtCatId(catId.getCatId());
        article.setArtTagId(tagId.getTagId());
        //加入数据库中进行填充
        articleMapper.insert(article);

        //反设置给公共计数表
        boolean countIdTag = tagArtCountService.findCountId(tagId.getTagId(),addBlog.getUserId());
        if (countIdTag){
            tagArtCountService.saveTagId( tagId.getTagId(),addBlog.getUserId());
        }else {
            tagArtCountService.updateCount( tagId.getTagId(),addBlog.getUserId());
        }

        //反设置给公共计数表
        boolean countIdCat = catArtCountService.findCountId(catId.getCatId(),addBlog.getUserId());
        if (countIdCat){
            //新标签保存
            catArtCountService.saveCagId(catId.getCatId(),addBlog.getUserId());
        }else {
            //保存过得标签进行计数
            catArtCountService.updateCount(catId.getCatId(),addBlog.getUserId());
        }
    }

    @Override
    public List<Article> findAllByUserId(Long userId) {
        List<Article> articles = articleMapper.findAllByUserId(userId);
        return articles;
    }

    @Override
    public Article findArticleAll(Long artId,Long artUserId) {
        try{
            Article articleAll = articleMapper.findArticleAll(artId,artUserId);
            return articleAll;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Article> findDatebyArt(Long userId) {
        return articleMapper.findDatebyArt(userId);
    }

    @Override
    public List<Article> findViewByDesc(Long userId) {
        return articleMapper.findViewByDesc(userId);
    }

    @Override
    public List<Article> findLikeByDesc(Long userId) {
        return articleMapper.findLikeByDesc(userId);
    }

    @Override
    public Article findArticle(Long artId) {

        return articleMapper.findArticle(artId);
    }

    @Override
    public void updateArticle(AddBlog addBlog) {

        Article articleAll = findArticleAll(addBlog.getArtId(), addBlog.getArtUserId());

        Tag tagId;
        //标签下的id,name 判断输入的标签是否存在
        Tag bytagName = tagService.findBytagName(addBlog.getTagName(), addBlog.getArtUserId());
        System.out.println("bytagName.getTagName()="+bytagName.getTagName());
        if (bytagName.getTagName() == null){
            //新增入标签
            Tag tag = new Tag();
            tag.setTagName(addBlog.getTagName());
            tag.setTagUserId(addBlog.getArtUserId());
            tagMapper.saveAll(tag);
            //获取id：存入article
             tagId = tagService.findTagId(addBlog.getTagName(),addBlog.getArtUserId());
             tagArtCountService.saveTagId(tagId.getTagId(),addBlog.getArtUserId());
        }else{
            //存在标签
            //判断是否计数
            //查询下article下 tag，cat id：判断输入的是否相等
            Article byartTagCatId = findByartTagCatId(addBlog.getArtId(), addBlog.getArtUserId());
            System.out.println("bytagName.getTagId().equals(byartTagCatId.getArtTagId())="+bytagName.getTagId().equals(byartTagCatId.getArtTagId()));
            if (bytagName.getTagId().equals(byartTagCatId.getArtTagId())){
                //标签相同下
                tagId = tagService.findTagId(addBlog.getTagName(),addBlog.getArtUserId());
            }else {
                tagId = tagService.findTagId(addBlog.getTagName(),addBlog.getArtUserId());
                //与article标签不同：需改变状态
                //判断新增还是累加
                boolean countId = tagArtCountService.findCountId(tagId.getTagId(), addBlog.getArtUserId());
                System.out.println("countTagId="+countId);
                if (countId){
                    tagArtCountService.saveTagId(tagId.getTagId(),addBlog.getArtUserId());
                }else {
                    tagArtCountService.updateCount(tagId.getTagId(),addBlog.getArtUserId());
                    tagArtCountService.updateCountBySmall(articleAll.getArtTagId(),addBlog.getArtUserId());

                }
            }
        }

        //分类不存在情况下
        Category catId;
        Category bycatName = categoryService.findBycatName(addBlog.getCatName(), addBlog.getArtUserId());
        System.out.println("bycatName.getCatName()="+bycatName.getCatName());
        if (bycatName.getCatName() == null) {
            //新增入
            Category category = new Category();
            category.setCatName(addBlog.getCatName());
            category.setCatUserId(addBlog.getArtUserId());
            categoryMapper.saveAll(category);
            //获取id存入article
             catId = categoryService.findCatId(addBlog.getCatName(),addBlog.getArtUserId());
             catArtCountService.saveCagId(catId.getCatId(),addBlog.getArtUserId());
        } else {
            //存在分类下
            Article byartTagCatId = findByartTagCatId(addBlog.getArtId(), addBlog.getArtUserId());
            System.out.println("bycatName.getCatId().equals(byartTagCatId.getArtCatId())="+bycatName.getCatId().equals(byartTagCatId.getArtCatId()));
            if (bycatName.getCatId().equals(byartTagCatId.getArtCatId())){
                catId = categoryService.findCatId(addBlog.getCatName(),addBlog.getArtUserId());
            }else {
                catId = categoryService.findCatId(addBlog.getCatName(),addBlog.getArtUserId());
                boolean countId = catArtCountService.findCountId(catId.getCatId(), addBlog.getArtUserId());
                System.out.println("countCatId="+countId);
                if (countId){
                    catArtCountService.saveCagId(catId.getCatId(),addBlog.getArtUserId());
                }else {
                    catArtCountService.updateCount(catId.getCatId(),addBlog.getArtUserId());
                    catArtCountService.updateCount(catId.getCatId(),addBlog.getArtUserId());
                }
            }
        }

        Article article = new Article();
        article.setArtContent(addBlog.getArtContent());
        article.setArtTitle(addBlog.getArtTitle());
        article.setArtTop(addBlog.getArtTop());
        article.setArtPoint(addBlog.getArtPoint());
        article.setArtDesc(addBlog.getArtDesc());
        article.setArtOpenPrivate(addBlog.getArtOpenPrivate());
        article.setArtStatus(addBlog.getArtStatus());
        article.setArtUpdatedate(new Date());
        article.setArtCatId(catId.getCatId());
        System.out.println("catId.getCatId()="+catId.getCatId());
        article.setArtTagId(tagId.getTagId());
        System.out.println("tagId.getTagId()="+tagId.getTagId());
        article.setArtId(addBlog.getArtId());
        article.setArtUserId(addBlog.getArtUserId());
        articleMapper.updateArticle(article);
    }

    @Override
    public Article findByartTagCatId(Long artId, Long artUserId) {
        return articleMapper.findByartTagCatId(artId, artUserId);
    }


   /* public List<Article> getTagsIdAndCountArt(Long userId){
        List<Article> tagsIdAndCountArt = articleMapper.findTagsIdAndCountArt(userId);
        return tagsIdAndCountArt;

    }*/
}
