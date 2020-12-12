package com.bootdo.system.service;

import com.bootdo.system.domain.ChartFuturesDO;

import java.util.List;
import java.util.Map;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-13 00:31:40
 */
public interface ChartFuturesService {

    ChartFuturesDO get(Integer id);

    List<ChartFuturesDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ChartFuturesDO chartFutures);

    int update(ChartFuturesDO chartFutures);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
