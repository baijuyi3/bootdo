package com.bootdo.system.service;

import com.bootdo.system.domain.TransactionDO;

import java.util.List;
import java.util.Map;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-15 23:49:23
 */
public interface TransactionService {

    TransactionDO get(Integer id);

    List<TransactionDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(TransactionDO transaction);

    int update(TransactionDO transaction);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
