package cn.cllover.myblog.front.controller;

import cn.cllover.myblog.common.annotion.SLog;
import cn.cllover.myblog.common.controller.BaseController;
import cn.cllover.myblog.common.entries.AddBlog;
import cn.cllover.myblog.common.util.Status;
import cn.cllover.myblog.front.pojo.Article;
import cn.cllover.myblog.front.pojo.Category;
import cn.cllover.myblog.front.pojo.Tag;
import cn.cllover.myblog.front.pojo.User;
import cn.cllover.myblog.front.service.*;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagArtCountService tagArtCountService;
    @Autowired
    private CatArtCountService catArtCountService;

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @RequestMapping("add_blog")
    public String add(Model model,Long userId) {
        User currentUser = super.getCurrentUser();
        model.addAttribute("user",currentUser);
        //获取分类
        List<Category> cats = categoryService.findCats(currentUser.getUserId());
        model.addAttribute("cats",cats);
        //获取标签
        List<Tag> tags = tagService.findTags(currentUser.getUserId());
        model.addAttribute("tags",tags);

        return "add_blog";
    }



    @SLog("添加博客")
    @PostMapping( "addBlog")
    @ResponseBody
    public Status saveAll(@RequestBody AddBlog addBlog){

        JSONObject jsonObject = new JSONObject();
        if (addBlog.getUserId().equals(super.getCurrentUser().getUserId())){

            articleService.saveAll(addBlog);
            jsonObject.put("msg","添加成功");
            return Status.success("用户同步成功");
        }
        jsonObject.put("msg","请重新登录!");
        return Status.erroy("用户未同步");

    }

    @RequestMapping("u/article/{artId}")
    public String article(@PathVariable("artId") Long artId,Model model) {
        User currentUser = super.getCurrentUser();
        model.addAttribute("user",currentUser);
        Article article = articleService.findArticle(artId);
        model.addAttribute("article",article);
        return "article/article";
    }


    @RequestMapping("u/edit_blog/{artId}")
    public String edit(Model model,@PathVariable("artId") Long artId){
        User currentUser = super.getCurrentUser();
        model.addAttribute("user",currentUser);
        Article allByUserId = articleService.findArticleAll(artId, currentUser.getUserId());
        model.addAttribute("editArticle",allByUserId);
        //获取分类
        List<Category> cats = categoryService.findCats(currentUser.getUserId());
        model.addAttribute("cats",cats);
        //获取标签
        List<Tag> tags = tagService.findTags(currentUser.getUserId());
        model.addAttribute("tags",tags);
        return "edit_blog";
    }

    @PostMapping( "u/edit_blog")
    @ResponseBody
    public Status updateArticle(@RequestBody AddBlog addBlog){
        try{
            System.out.println("addBlog="+addBlog);
            articleService.updateArticle(addBlog);
            return Status.success("修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return Status.erroy("修改异常！").add("Exception",e.getMessage());
        }
    }
}
