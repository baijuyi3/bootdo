package com.bootdo.futures.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.futures.domain.FuturesDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-11-23 17:55:53
 */
@Mapper
public interface FuturesDao {

    FuturesDO get(Integer id);

    List<FuturesDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(FuturesDO futures);

    int update(FuturesDO futures);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
