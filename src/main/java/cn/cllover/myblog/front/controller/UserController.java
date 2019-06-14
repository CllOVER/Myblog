package cn.cllover.myblog.front.controller;


import cn.cllover.myblog.common.annotion.SLog;
import cn.cllover.myblog.common.controller.BaseController;
import cn.cllover.myblog.common.util.FileUtil;
import cn.cllover.myblog.common.util.Status;
import cn.cllover.myblog.front.pojo.Article;
import cn.cllover.myblog.front.pojo.Category;
import cn.cllover.myblog.front.pojo.Tag;
import cn.cllover.myblog.front.pojo.User;
import cn.cllover.myblog.front.service.ArticleService;
import cn.cllover.myblog.front.service.CategoryService;
import cn.cllover.myblog.front.service.TagService;
import cn.cllover.myblog.front.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("u")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("home")
    public String home(Model model) {
        User currentUser = super.getCurrentUser();
        model.addAttribute("user",currentUser);
        return "home";
    }

    @SLog("个人主页")
    @RequestMapping("home/getArt/{userId}")
    @ResponseBody
    public Status getAll(@PathVariable(name = "userId") Long userId,
                         @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        User currentUser = super.getCurrentUser();
        PageHelper.startPage(pn,8);
        List<Article> article = articleService.findAllByUserId(currentUser.getUserId());
        PageInfo pageInfo = new PageInfo(article,3);
        return Status.success("查询成功").add("article",pageInfo);

    }


    //更改规范为TagController  >>    getTagsAndArt
    @RequestMapping("home/getTags/{userId}")
    @ResponseBody
    public Status getTagsAndArt(@PathVariable(name = "userId") Long userId){
        List<Tag> tags = tagService.findTags(userId);
//        List<Article> tagsIdAndCountArt = articleService.getTagsIdAndCountArt(userId);
        return Status.success("执行成功").add("tags",tags);

    }

    //更改规范为TagController  >>    getTagsAndArt
    @RequestMapping("home/getCats/{userId}")
    @ResponseBody
    public Status getCatsAndArt(@PathVariable(name = "userId") Long userId){
        List<Category> cats = categoryService.findCats(userId);
        return Status.success("执行成功").add("cats",cats);

    }

    //更改规范为TagController  >>    getTagsAndArt
    @RequestMapping("home/getDate/{userId}")
    @ResponseBody
    public Status getDatebyArt(@PathVariable(name = "userId") Long userId){
        List<Article> date = articleService.findDatebyArt(userId);
        return Status.success("执行成功").add("date",date);

    }

    @RequestMapping("home/getArtViewByDesc/{userId}")
    @ResponseBody
    public Status getAllViewByDesc(@PathVariable(name = "userId") Long userId){
        List<Article> allByDesc = articleService.findViewByDesc(userId);
        return Status.success("执行成功").add("ArtViewByDesc",allByDesc);

    }

    @RequestMapping("home/getArtLikeByDesc/{userId}")
    @ResponseBody
    public Status getAllLikeByDesc(@PathVariable(name = "userId") Long userId){
        List<Article> allByDesc = articleService.findLikeByDesc(userId);
        return Status.success("执行成功").add("ArtLikeByDesc",allByDesc);

    }


    @RequestMapping("home/system/getAll")
    @ResponseBody
    public Status getAll(){
        Long userId = super.getCurrentUser().getUserId();
        List<User> all = userService.findAll(userId);
        return Status.success("查询成功").add("user",all);

    }

    @PutMapping("home/system/updateUser")
    @ResponseBody
    public Status updateUser(@RequestBody User user){
        userService.updateByPrimaryKeyBySelective(user);
       return Status.success("修改成功");
    }

    @PostMapping("home/photo/upload")
    @ResponseBody
    public Status handleFileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        String contentType = file.getContentType();
        long size = file.getSize();
        System.out.println(size);
        String fileName = FileUtil.getUUID()+file.getOriginalFilename();
        System.out.println("contentType="+contentType);
        System.out.println("filename="+fileName);
        String filePath = "D:/workspace/myblog/src/main/resources/static/photo_images/";
        System.out.println("filePath="+filePath);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
        }
        return Status.success("上传成功");
    }
}
