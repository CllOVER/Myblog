package cn.cllover.myblog.front.dao;

import cn.cllover.myblog.common.MyMapper;
import cn.cllover.myblog.front.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper extends MyMapper<Tag> {

    List<Tag> findAndcount(Long userId);

    void saveAll(Tag record);

    List<Tag> findTagsIdAndCountArt(Long userId);

    Long findByCounttagName(@Param("tagName") String tagName,@Param("tagUserId")Long tagUserId);

    Tag findBytagName(@Param("tagName") String tagName,@Param("tagUserId")Long tagUserId);
}