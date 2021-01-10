package com.bootdo.system.service;

import com.bootdo.system.domain.FuturesHourDO;

import java.util.List;
import java.util.Map;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-01-06 19:38:00
 */
public interface FuturesHourService {

    FuturesHourDO get(String trancode);

    List<FuturesHourDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(FuturesHourDO futuresHour);

    int update(FuturesHourDO futuresHour);

    int remove(String trancode);

    int batchRemove(String[] trancodes);
}
