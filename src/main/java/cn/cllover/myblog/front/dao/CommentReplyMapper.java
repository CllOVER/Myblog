package cn.cllover.myblog.front.dao;

import cn.cllover.myblog.common.MyMapper;
import cn.cllover.myblog.front.pojo.CommentReply;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentReplyMapper extends MyMapper<CommentReply> {

    List<CommentReply> findByComment(@Param("reUseredId") Long reUseredId,@Param("reComId")Long reComId);
}