package com.bootdo.futures.service.impl;

import com.bootdo.futures.dao.FuturesDao;
import com.bootdo.futures.domain.FuturesDO;
import com.bootdo.futures.service.FuturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class FuturesServiceImpl implements FuturesService {
    @Autowired
    private FuturesDao futuresDao;

    @Override
    public FuturesDO get(Integer id) {
        return futuresDao.get(id);
    }

    @Override
    public List<FuturesDO> list(Map<String, Object> map) {
        return futuresDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return futuresDao.count(map);
    }

    @Override
    public int save(FuturesDO futures) {
        return futuresDao.save(futures);
    }

    @Override
    public int update(FuturesDO futures) {
        return futuresDao.update(futures);
    }

    @Override
    public int remove(Integer id) {
        return futuresDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return futuresDao.batchRemove(ids);
    }

}
