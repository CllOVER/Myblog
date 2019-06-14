package cn.cllover.myblog.front.service;

import cn.cllover.myblog.common.service.BaseService;
import cn.cllover.myblog.front.pojo.CommentReply;

import java.util.List;

public interface CommentReplyService extends BaseService<CommentReply> {
    List<CommentReply> findByComment(Long reUseredId,Long reComId);
}
