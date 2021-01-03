package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.WhchartDao;
import com.bootdo.system.domain.WhchartDO;
import com.bootdo.system.service.WhchartService;


@Service
public class WhchartServiceImpl implements WhchartService {
    @Autowired
    private WhchartDao whchartDao;

    @Override
    public WhchartDO get(Integer id) {
        return whchartDao.get(id);
    }

    @Override
    public List<WhchartDO> list(Map<String, Object> map) {
        return whchartDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return whchartDao.count(map);
    }

    @Override
    public int save(WhchartDO whchart) {
        return whchartDao.save(whchart);
    }

    @Override
    public int update(WhchartDO whchart) {
        return whchartDao.update(whchart);
    }

    @Override
    public int remove(Integer id) {
        return whchartDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return whchartDao.batchRemove(ids);
    }

}
