package cn.cllover.myblog.front.service.impl;

import cn.cllover.myblog.common.service.BaseService;
import cn.cllover.myblog.common.service.impl.BaseServiceimpl;
import cn.cllover.myblog.front.dao.CommentReplyMapper;
import cn.cllover.myblog.front.pojo.CommentReply;
import cn.cllover.myblog.front.service.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentReplyService")
public class CommentReplyServiceimpl extends BaseServiceimpl<CommentReply> implements CommentReplyService {

    @Autowired
    private CommentReplyMapper commentReplyMapper;

    @Override
    public List<CommentReply> findByComment(Long reUseredId,Long reComId) {
        return commentReplyMapper.findByComment(reUseredId,reComId);
    }
}
