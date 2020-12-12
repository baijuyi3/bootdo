package com.bootdo.system.dao;

import com.bootdo.system.domain.ChartFuturesDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-13 00:31:40
 */
@Mapper
public interface ChartFuturesDao {

    ChartFuturesDO get(Integer id);

    List<ChartFuturesDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ChartFuturesDO chartFutures);

    int update(ChartFuturesDO chartFutures);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
