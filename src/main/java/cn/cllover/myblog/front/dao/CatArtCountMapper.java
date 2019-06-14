package cn.cllover.myblog.front.dao;

import cn.cllover.myblog.common.MyMapper;
import cn.cllover.myblog.front.pojo.CatArtCount;
import org.apache.ibatis.annotations.Param;

public interface CatArtCountMapper extends MyMapper<CatArtCount> {

    long findCountId(@Param("caId")Long caId,@Param("CaUserId")Long CaUserId);

    int updateCount(@Param("caId")Long caId,@Param("CaUserId")Long CaUserId);

    int updateCountBySmall(@Param("caId")Long caId,@Param("CaUserId")Long CaUserId);

    int saveCagId( @Param("caId")Long caId,@Param("CaUserId")Long CaUserId);
}
