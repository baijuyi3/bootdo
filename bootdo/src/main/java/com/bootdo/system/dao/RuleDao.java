package com.bootdo.system.dao;

import com.bootdo.system.domain.RuleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-08 21:45:19
 */
@Mapper
public interface RuleDao {

    RuleDO get(Integer id);

    List<RuleDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RuleDO rule);

    int update(RuleDO rule);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}