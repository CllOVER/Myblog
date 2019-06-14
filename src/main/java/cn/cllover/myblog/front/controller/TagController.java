package cn.cllover.myblog.front.controller;

import cn.cllover.myblog.common.controller.BaseController;
import cn.cllover.myblog.common.util.Status;
import cn.cllover.myblog.front.pojo.Tag;
import cn.cllover.myblog.front.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TagController extends BaseController {

    @Autowired
    private TagService tagService;


    @RequestMapping("manage/getTags/{userId}")
    @ResponseBody
    public Status getTagsAndArt(@PathVariable(name = "userId") Long userId,
                                @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,8);
        List<Tag> tags = tagService.findAndcount(userId);
        PageInfo pageInfo = new PageInfo(tags,3);
        return Status.success("执行成功").add("tags",pageInfo);

    }

}
