package cn.cllover.myblog.front.service.impl;

import cn.cllover.myblog.common.service.impl.BaseServiceimpl;
import cn.cllover.myblog.front.dao.CommentMapper;
import cn.cllover.myblog.front.pojo.Comment;
import cn.cllover.myblog.front.pojo.CommentReply;
import cn.cllover.myblog.front.service.CommentReplyService;
import cn.cllover.myblog.front.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("CommentService")
public class CommentServiceimpl extends BaseServiceimpl<Comment> implements CommentService {


    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentReplyService commentReplyService;

    @Override
    public int saveComment(Comment comment) {
        return commentMapper.saveComment(comment);
    }

    @Override
    public List<Comment> findAllByUser(Long comArtId) {
        return commentMapper.findAllByUser(comArtId);
    }




    public Map<Object, Object> getParentNode(Long comArtId){
        List<Comment> parentNodeByOne = new ArrayList();
        List<CommentReply> childByParennt = new ArrayList();
        Map<Object, Object> commentreplyMaps = new HashMap();

        List<Comment> allByOne = commentMapper.findAllByOne(comArtId);

        for (Comment comment :allByOne){
            if (comment.getComStatus() != 0){
                List<CommentReply> childNode  = getChildNode(comment.getComUserId(),comment.getComId());
                for ( CommentReply childlist :childNode){
                    childByParennt.add(childlist);
                }
            }
            parentNodeByOne.add(comment);
        }

        commentreplyMaps.put(parentNodeByOne, childByParennt);

        return commentreplyMaps;
    }

    public List<CommentReply> getChildNode(Long reUseredId,Long reComId){
        List<CommentReply> childNode = commentReplyService.findByComment(reUseredId,reComId);
        System.out.println(childNode);
        return childNode;
    }

}
