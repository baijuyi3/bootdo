package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.TransactionDO;
import com.bootdo.system.service.TransactionService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-15 23:49:23
 */

@Controller
@RequestMapping("/system/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping()
    @RequiresPermissions("system:transaction:transaction")
    String Transaction() {
        return "system/transaction/transaction";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:transaction:transaction")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<TransactionDO> transactionList = transactionService.list(query);
        int total = transactionService.count(query);
        PageUtils pageUtils = new PageUtils(transactionList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:transaction:add")
    String add() {
        return "system/transaction/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:transaction:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        TransactionDO transaction = transactionService.get(id);
        model.addAttribute("transaction", transaction);
        return "system/transaction/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:transaction:add")
    public R save(TransactionDO transaction) {
        if (transactionService.save(transaction) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:transaction:edit")
    public R update(TransactionDO transaction) {
        transactionService.update(transaction);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:transaction:remove")
    public R remove(Integer id) {
        if (transactionService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:transaction:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        transactionService.batchRemove(ids);
        return R.ok();
    }

}
