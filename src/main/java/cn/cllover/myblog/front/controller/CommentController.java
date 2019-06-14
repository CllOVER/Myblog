package cn.cllover.myblog.front.controller;

import cn.cllover.myblog.common.controller.BaseController;
import cn.cllover.myblog.common.util.IPUtil;
import cn.cllover.myblog.common.util.Status;
import cn.cllover.myblog.front.pojo.Comment;
import cn.cllover.myblog.front.service.CommentService;
import com.alibaba.druid.support.spring.stat.annotation.Stat;
import javafx.scene.chart.StackedAreaChart;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController extends BaseController {


    @Autowired
    private CommentService commentService;


    @PostMapping("u/home/article/comment/add")
    @ResponseBody
    public Status saveComment(@RequestBody Comment comment,HttpServletRequest httpServletRequest){
        try{
            Comment comment1 = new Comment();
            comment1.setComDate(new Date());
            comment1.setComIp(IPUtil.getIpAddress(httpServletRequest));
            comment1.setComArtId(comment.getComArtId());
            comment1.setComUserId(comment.getComUserId());
            comment1.setComContent(comment.getComContent());
            commentService.saveComment(comment1);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Status.erroy("添加失败！");
        }
        return Status.success("添加成功！");
    }

    @RequestMapping("u/home/article/comment/list/{comArtId}")
    @ResponseBody
    public Status findAll(@PathVariable("comArtId") Long comArtId){
        List<Comment> allByOne = commentService.findAllByUser(comArtId);
        return Status.success("查询成功").add("comment",allByOne);
    }
}
