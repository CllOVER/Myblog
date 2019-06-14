package cn.cllover.myblog.front.service.impl;

import cn.cllover.myblog.common.service.impl.BaseServiceimpl;
import cn.cllover.myblog.front.dao.CatArtCountMapper;
import cn.cllover.myblog.front.pojo.CatArtCount;
import cn.cllover.myblog.front.service.CatArtCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CatArtCountService")
public class CatArtCountServiceimpl extends BaseServiceimpl<CatArtCount> implements CatArtCountService {

    @Autowired
    private CatArtCountMapper catArtCountMapper;


    @Override
    public boolean findCountId(Long caId,Long CaUserId) {
        long countId = catArtCountMapper.findCountId(caId,CaUserId);
        return countId == 0;
    }


    @Override
    public int updateCount(Long caId,Long CaUserId) {
        return catArtCountMapper.updateCount(caId,CaUserId);
    }

    @Override
    public int updateCountBySmall(Long caId, Long CaUserId) {
        return catArtCountMapper.updateCountBySmall(caId,CaUserId);
    }

    @Override
    public int saveCagId(Long caId,Long CaUserId) {
        return catArtCountMapper.saveCagId(caId,CaUserId);
    }
}
