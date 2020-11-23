package com.bootdo.futures.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.futures.domain.FuturesDO;
import com.bootdo.futures.service.FuturesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-11-23 17:55:53
 */

@Controller
@RequestMapping("/system/futures")
public class FuturesController {
    @Autowired
    private FuturesService futuresService;

    @GetMapping()
    @RequiresPermissions("system:futures:futures")
    String Futures() {
        return "system/futures/futures";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:futures:futures")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<FuturesDO> futuresList = futuresService.list(query);
        int total = futuresService.count(query);
        PageUtils pageUtils = new PageUtils(futuresList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:futures:add")
    String add() {
        return "system/futures/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:futures:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        FuturesDO futures = futuresService.get(id);
        model.addAttribute("futures", futures);
        return "system/futures/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:futures:add")
    public R save(FuturesDO futures) {
        if (futuresService.save(futures) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:futures:edit")
    public R update(FuturesDO futures) {
        futuresService.update(futures);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:futures:remove")
    public R remove(Integer id) {
        if (futuresService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:futures:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        futuresService.batchRemove(ids);
        return R.ok();
    }

}
