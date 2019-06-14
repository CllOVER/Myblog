package cn.cllover.myblog.front.service;

import cn.cllover.myblog.common.service.BaseService;
import cn.cllover.myblog.front.pojo.SLog;

public interface SLogService extends BaseService<SLog> {

    void saveAll(SLog entry);
}
