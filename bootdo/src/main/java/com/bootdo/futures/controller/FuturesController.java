package com.bootdo.futures.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.futures.domain.FuturesDO;
import com.bootdo.futures.service.FuturesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-11-23 17:55:53
 */

@Controller
@RequestMapping("futures")
public class FuturesController {
    @Autowired
    private FuturesService futuresService;


    @GetMapping()
    String Futures() {
        return "futures/futures";
    }

    @RequestMapping(value = "/history", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<FuturesDO> history(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<FuturesDO> futuresList = futuresService.likeList(params);
        return futuresList;
    }


    @GetMapping("/list")
    @ResponseBody
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<FuturesDO> futuresList = futuresService.list(query);
        int total = futuresService.count(query);
        PageUtils pageUtils = new PageUtils(futuresList, total);
        return pageUtils;
    }


    @GetMapping("/graph_echarts")
    String chart() {
        return "futures/graph_echarts";
    }

    @GetMapping("/add")
    @RequiresPermissions("futures:add")
    String add() {
        return "futures/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model) {
        FuturesDO futures = futuresService.get(id);
        model.addAttribute("futures", futures);
        return "futures/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
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
    public R update(FuturesDO futures) {
        futuresService.update(futures);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
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
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        futuresService.batchRemove(ids);
        return R.ok();
    }

}
