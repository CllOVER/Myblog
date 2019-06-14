package cn.cllover.myblog.front.service;

import cn.cllover.myblog.common.service.BaseService;
import cn.cllover.myblog.front.pojo.Comment;

import java.util.List;


public interface CommentService extends BaseService<Comment> {

    int saveComment(Comment comment);

    List<Comment> findAllByUser(Long comArtId);

}
