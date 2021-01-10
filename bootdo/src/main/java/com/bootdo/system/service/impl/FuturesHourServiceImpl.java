package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.FuturesHourDao;
import com.bootdo.system.domain.FuturesHourDO;
import com.bootdo.system.service.FuturesHourService;


@Service
public class FuturesHourServiceImpl implements FuturesHourService {
    @Autowired
    private FuturesHourDao futuresHourDao;

    @Override
    public FuturesHourDO get(String trancode) {
        return futuresHourDao.get(trancode);
    }

    @Override
    public List<FuturesHourDO> list(Map<String, Object> map) {
        return futuresHourDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return futuresHourDao.count(map);
    }

    @Override
    public int save(FuturesHourDO futuresHour) {
        return futuresHourDao.save(futuresHour);
    }

    @Override
    public int update(FuturesHourDO futuresHour) {
        return futuresHourDao.update(futuresHour);
    }

    @Override
    public int remove(String trancode) {
        return futuresHourDao.remove(trancode);
    }

    @Override
    public int batchRemove(String[] trancodes) {
        return futuresHourDao.batchRemove(trancodes);
    }

}
