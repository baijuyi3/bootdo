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

import com.bootdo.system.domain.FuturesHourDO;
import com.bootdo.system.service.FuturesHourService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-01-06 19:38:00
 */

@Controller
@RequestMapping("/system/futuresHour")
public class FuturesHourController {
    @Autowired
    private FuturesHourService futuresHourService;

    @GetMapping()
    @RequiresPermissions("system:futuresHour:futuresHour")
    String FuturesHour() {
        return "system/futuresHour/futuresHour";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:futuresHour:futuresHour")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<FuturesHourDO> futuresHourList = futuresHourService.list(query);
        int total = futuresHourService.count(query);
        PageUtils pageUtils = new PageUtils(futuresHourList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:futuresHour:add")
    String add() {
        return "system/futuresHour/add";
    }

    @GetMapping("/edit/{trancode}")
    @RequiresPermissions("system:futuresHour:edit")
    String edit(@PathVariable("trancode") String trancode, Model model) {
        FuturesHourDO futuresHour = futuresHourService.get(trancode);
        model.addAttribute("futuresHour", futuresHour);
        return "system/futuresHour/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:futuresHour:add")
    public R save(FuturesHourDO futuresHour) {
        if (futuresHourService.save(futuresHour) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:futuresHour:edit")
    public R update(FuturesHourDO futuresHour) {
        futuresHourService.update(futuresHour);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:futuresHour:remove")
    public R remove(String trancode) {
        if (futuresHourService.remove(trancode) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:futuresHour:batchRemove")
    public R remove(@RequestParam("ids[]") String[] trancodes) {
        futuresHourService.batchRemove(trancodes);
        return R.ok();
    }

}
