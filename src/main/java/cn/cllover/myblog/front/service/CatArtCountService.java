package cn.cllover.myblog.front.service;

import cn.cllover.myblog.common.service.BaseService;
import cn.cllover.myblog.front.pojo.CatArtCount;

public interface CatArtCountService extends BaseService<CatArtCount> {

    boolean findCountId(Long caId,Long CaUserId);

    int updateCount(Long caId,Long CaUserId);

    int updateCountBySmall(Long caId,Long CaUserId);

    int saveCagId(Long caId,Long CaUserId);
}
