package cn.cllover.myblog.front.service.impl;

import cn.cllover.myblog.common.service.impl.BaseServiceimpl;
import cn.cllover.myblog.front.dao.TagArtCountMapper;
import cn.cllover.myblog.front.pojo.TagArtCount;
import cn.cllover.myblog.front.service.TagArtCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("TagArtCountService")
public class TagArtCountServiceimpl extends BaseServiceimpl<TagArtCount> implements TagArtCountService {

    @Autowired
    private TagArtCountMapper tagArtCountMapper;


    @Override
    public boolean findCountId(Long taId,Long TaUserId) {
       long  countId = tagArtCountMapper.findCountId(taId,TaUserId);
        System.out.println("countId="+countId);
        return countId == 0 ;
    }



    @Override
    public int updateCount(Long taId,Long TaUserId) {
        return tagArtCountMapper.updateCount(taId,TaUserId);
    }

    @Override
    public int updateCountBySmall(Long taId, Long TaUserId) {
        return tagArtCountMapper.updateCountBySmall(taId, TaUserId);
    }

    @Override
    public int saveTagId(Long taId,Long TaUserId) {
        return tagArtCountMapper.saveTagId(taId, TaUserId);
    }

}
