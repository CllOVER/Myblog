package cn.cllover.myblog.front.service;

import cn.cllover.myblog.common.entries.AddBlog;
import cn.cllover.myblog.common.service.BaseService;
import cn.cllover.myblog.front.pojo.Article;
import cn.cllover.myblog.front.pojo.Category;
import cn.cllover.myblog.front.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService extends BaseService<Article> {

    void saveAll(AddBlog addBlog);

    List<Article> findAllByUserId(Long userId);

    Article findArticleAll(Long artId,Long artUserId);

    List<Article> findDatebyArt(Long userId);

    List<Article> findViewByDesc(Long userId);

    List<Article> findLikeByDesc(Long userId);

    Article findArticle(Long artId);

    void updateArticle(AddBlog addBlog);

    Article findByartTagCatId(Long artId, Long artUserId);

//    List<Article> getTagsIdAndCountArt(Long userId);
}
