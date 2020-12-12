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

import com.bootdo.system.domain.ChartFuturesDO;
import com.bootdo.system.service.ChartFuturesService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-13 00:31:40
 */

@Controller
@RequestMapping("/system/chartFutures")
public class ChartFuturesController {
    @Autowired
    private ChartFuturesService chartFuturesService;

    @GetMapping()
    @RequiresPermissions("system:chartFutures:chartFutures")
    String ChartFutures() {
        return "system/chartFutures/chartFutures";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:chartFutures:chartFutures")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ChartFuturesDO> chartFuturesList = chartFuturesService.list(query);
        int total = chartFuturesService.count(query);
        PageUtils pageUtils = new PageUtils(chartFuturesList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:chartFutures:add")
    String add() {
        return "system/chartFutures/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:chartFutures:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        ChartFuturesDO chartFutures = chartFuturesService.get(id);
        model.addAttribute("chartFutures", chartFutures);
        return "system/chartFutures/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:chartFutures:add")
    public R save(ChartFuturesDO chartFutures) {
        if (chartFuturesService.save(chartFutures) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:chartFutures:edit")
    public R update(ChartFuturesDO chartFutures) {
        chartFuturesService.update(chartFutures);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:chartFutures:remove")
    public R remove(Integer id) {
        if (chartFuturesService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:chartFutures:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        chartFuturesService.batchRemove(ids);
        return R.ok();
    }

}
