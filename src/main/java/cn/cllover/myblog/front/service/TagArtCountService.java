package cn.cllover.myblog.front.service;

import cn.cllover.myblog.common.service.BaseService;
import cn.cllover.myblog.front.pojo.TagArtCount;
import org.apache.ibatis.annotations.Param;


public interface TagArtCountService extends BaseService<TagArtCount> {

    boolean findCountId(Long taId,Long TaUserId);

    int updateCount(Long taId,Long TaUserId);

    int updateCountBySmall(Long taId,Long TaUserId);

    int saveTagId(Long taId,Long TaUserId);
}
