package cn.cllover.myblog.front.service.impl;

import cn.cllover.myblog.common.service.impl.BaseServiceimpl;
import cn.cllover.myblog.front.dao.SLogMapper;
import cn.cllover.myblog.front.pojo.SLog;
import cn.cllover.myblog.front.service.SLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SLogService")
public class SLogServiceimpl extends BaseServiceimpl<SLog> implements SLogService {

    @Autowired
    private SLogMapper sLogMapper;

    @Override
    public void saveAll(SLog entry) {
        int insert = sLogMapper.insert(entry);
    }
}
