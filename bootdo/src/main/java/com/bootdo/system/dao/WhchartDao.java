package com.bootdo.system.dao;

import com.bootdo.system.domain.WhchartDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-01-03 22:49:09
 */
@Mapper
public interface WhchartDao {

    WhchartDO get(Integer id);

    List<WhchartDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(WhchartDO whchart);

    int update(WhchartDO whchart);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
