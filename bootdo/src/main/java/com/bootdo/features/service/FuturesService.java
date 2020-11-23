package com.bootdo.features.service;


import com.bootdo.features.domain.FuturesDO;

import java.util.List;
import java.util.Map;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-11-23 17:55:53
 */
public interface FuturesService {

    FuturesDO get(Integer id);

    List<FuturesDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(FuturesDO futures);

    int update(FuturesDO futures);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
