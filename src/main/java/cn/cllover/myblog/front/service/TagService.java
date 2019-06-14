package cn.cllover.myblog.front.service;

import cn.cllover.myblog.common.service.BaseService;
import cn.cllover.myblog.front.pojo.Tag;

import java.util.List;

public interface TagService extends BaseService<Tag> {

    List<Tag> findAndcount(Long userId);

    List<Tag> findTags(Long userId);

    Tag findTagId(String tagName,Long userId);

    boolean findByCounttagName(String tagName,Long tagUserId);

    Tag findBytagName(String tagName,Long tagUserId);

}
