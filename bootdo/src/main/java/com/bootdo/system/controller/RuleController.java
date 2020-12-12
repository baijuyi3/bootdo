package com.bootdo.system.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.bootdo.futures.domain.FuturesDO;
import com.bootdo.futures.service.FuturesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bootdo.system.domain.RuleDO;
import com.bootdo.system.service.RuleService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-08 21:45:19
 */

@Controller
@RequestMapping("/system/rule")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    @Autowired
    private FuturesService futuresService;

    @GetMapping()
    String Rule() {
        return "system/rule/rule";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RuleDO> ruleList = ruleService.list(query);
        int total = ruleService.count(query);
        PageUtils pageUtils = new PageUtils(ruleList, total);
        return pageUtils;
    }

    @RequestMapping(value = "/history", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<FuturesDO> history(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<FuturesDO> futuresList = futuresService.likeList(params);
        Long days;
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i < futuresList.size(); i++) {
            days = (futuresList.get(i).getTime().getTime() - futuresList.get(i + 1).getTime().getTime()) / (24 * 60 * 60 * 1000);
            if (days < 30) {

            }
        }
        return futuresList;
    }

    @GetMapping("/add")
    String add() {
        return "system/rule/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model) {
        RuleDO rule = ruleService.get(id);
        model.addAttribute("rule", rule);
        return "system/rule/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(RuleDO rule) {
        if (ruleService.save(rule) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(RuleDO rule) {
        ruleService.update(rule);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Integer id) {
        if (ruleService.remove(id) > 0) {
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
        ruleService.batchRemove(ids);
        return R.ok();
    }

}
