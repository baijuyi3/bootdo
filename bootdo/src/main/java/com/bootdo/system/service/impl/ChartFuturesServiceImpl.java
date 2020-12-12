package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.ChartFuturesDao;
import com.bootdo.system.domain.ChartFuturesDO;
import com.bootdo.system.service.ChartFuturesService;


@Service
public class ChartFuturesServiceImpl implements ChartFuturesService {
    @Autowired
    private ChartFuturesDao chartFuturesDao;

    @Override
    public ChartFuturesDO get(Integer id) {
        return chartFuturesDao.get(id);
    }

    @Override
    public List<ChartFuturesDO> list(Map<String, Object> map) {
        return chartFuturesDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return chartFuturesDao.count(map);
    }

    @Override
    public int save(ChartFuturesDO chartFutures) {
        return chartFuturesDao.save(chartFutures);
    }

    @Override
    public int update(ChartFuturesDO chartFutures) {
        return chartFuturesDao.update(chartFutures);
    }

    @Override
    public int remove(Integer id) {
        return chartFuturesDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return chartFuturesDao.batchRemove(ids);
    }

}
