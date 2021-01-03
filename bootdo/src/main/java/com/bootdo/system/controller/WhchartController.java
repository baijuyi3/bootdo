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

import com.bootdo.system.domain.WhchartDO;
import com.bootdo.system.service.WhchartService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-01-03 22:49:09
 */

@Controller
@RequestMapping("/system/whchart")
public class WhchartController {
    @Autowired
    private WhchartService whchartService;

    @GetMapping()
    @RequiresPermissions("system:whchart:whchart")
    String Whchart() {
        return "system/whchart/whchart";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:whchart:whchart")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<WhchartDO> whchartList = whchartService.list(query);
        int total = whchartService.count(query);
        PageUtils pageUtils = new PageUtils(whchartList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:whchart:add")
    String add() {
        return "system/whchart/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:whchart:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        WhchartDO whchart = whchartService.get(id);
        model.addAttribute("whchart", whchart);
        return "system/whchart/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:whchart:add")
    public R save(WhchartDO whchart) {
        if (whchartService.save(whchart) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:whchart:edit")
    public R update(WhchartDO whchart) {
        whchartService.update(whchart);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:whchart:remove")
    public R remove(Integer id) {
        if (whchartService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:whchart:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        whchartService.batchRemove(ids);
        return R.ok();
    }

}
