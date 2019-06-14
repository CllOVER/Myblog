package cn.cllover.myblog.front.dao;

import cn.cllover.myblog.common.MyMapper;
import cn.cllover.myblog.front.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {

    int saveComment(Comment comment);

    List<Comment> findAllByOne(Long comArtId);

    List<Comment> findAllByUser(Long comArtId);
}