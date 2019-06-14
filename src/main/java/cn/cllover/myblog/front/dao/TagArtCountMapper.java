package cn.cllover.myblog.front.dao;

import cn.cllover.myblog.common.MyMapper;
import cn.cllover.myblog.front.pojo.TagArtCount;
import org.apache.ibatis.annotations.Param;


public interface TagArtCountMapper extends MyMapper<TagArtCount> {

    long findCountId( @Param("taId")Long taId,@Param("TaUserId") Long TaUserId);

    int updateCount( @Param("taId")Long taId,@Param("TaUserId") Long TaUserId);

    int updateCountBySmall( @Param("taId")Long taId,@Param("TaUserId") Long TaUserId);

    int saveTagId(@Param("taId")Long taId,@Param("TaUserId") Long TaUserId);
}
