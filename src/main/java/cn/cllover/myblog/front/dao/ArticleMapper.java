package cn.cllover.myblog.front.dao;

import cn.cllover.myblog.common.MyMapper;
import cn.cllover.myblog.common.entries.AddBlog;
import cn.cllover.myblog.front.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper extends MyMapper<Article> {


    List<Article> findAllByUserId(Long userId);

    Article findArticleAll(@Param("artId")Long artId,@Param("artUserId") Long artUserId);

    List<Article> findDatebyArt(Long userId);

    List<Article> findViewByDesc(Long userId);

    List<Article> findLikeByDesc(Long userId);

    Article findArticle(Long artId);

    int updateArticle(Article article);

    Article findByartTagCatId(@Param("artId")Long artId,@Param("artUserId") Long artUserId);
//    List<Article> findTagsIdAndCountArt(long userId);
}