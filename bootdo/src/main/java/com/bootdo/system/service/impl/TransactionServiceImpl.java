package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.TransactionDao;
import com.bootdo.system.domain.TransactionDO;
import com.bootdo.system.service.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDao transactionDao;

    @Override
    public TransactionDO get(Integer id) {
        return transactionDao.get(id);
    }

    @Override
    public List<TransactionDO> list(Map<String, Object> map) {
        return transactionDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return transactionDao.count(map);
    }

    @Override
    public int save(TransactionDO transaction) {
        return transactionDao.save(transaction);
    }

    @Override
    public int update(TransactionDO transaction) {
        return transactionDao.update(transaction);
    }

    @Override
    public int remove(Integer id) {
        return transactionDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return transactionDao.batchRemove(ids);
    }

}
