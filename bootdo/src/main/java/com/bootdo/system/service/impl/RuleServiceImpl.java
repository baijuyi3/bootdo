package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.RuleDao;
import com.bootdo.system.domain.RuleDO;
import com.bootdo.system.service.RuleService;


@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    private RuleDao ruleDao;

    @Override
    public RuleDO get(Integer id) {
        return ruleDao.get(id);
    }

    @Override
    public List<RuleDO> list(Map<String, Object> map) {
        return ruleDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return ruleDao.count(map);
    }

    @Override
    public int save(RuleDO rule) {
        return ruleDao.save(rule);
    }

    @Override
    public int update(RuleDO rule) {
        return ruleDao.update(rule);
    }

    @Override
    public int remove(Integer id) {
        return ruleDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return ruleDao.batchRemove(ids);
    }

}
