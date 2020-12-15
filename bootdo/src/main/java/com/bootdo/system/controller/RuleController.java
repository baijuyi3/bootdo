package com.bootdo.system.controller;

import java.util.ArrayList;
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
        //总净利润
        Double profit = 0d;
        //毛利润
        Double grossProfit = 0d;
        //总亏损
        Double grossLoss = 0d;
        //总交易次数
        Integer totalTimes = 0;
        //总盈利交易次数
        Integer profitTimes = 0;
        //总亏损交易次数
        Integer lossTimes = 0;
        //利润率
        Double profitRate = 0d;
        //最大单笔盈利
        Double singleProfitMax = 0d;
        //盈利平均盈利
        Double singleProfitAvg = 0d;
        //最大单笔亏损
        Double singleLossMax = 0d;
        //亏损平均亏损
        Double singleLossAvg = 0d;
        //平均盈利/亏损比例
        Double profitLossRate = 0d;
        //平均交易盈亏总额
        Double profitLossAvg = 0d;
        //最多连续盈利次数
        Integer profitRunningTimes = 0;
        //最多连续亏损次数
        Integer lossRunningTimes = 0;
        //最大平仓亏损
        Double lossClosingPosition = 0d;
        //账户额度下限
        Double accountPriceLeast = 0d;
        //最大合约持有数
        Integer maxContract = 0;
        //账户收益率
        Double gainRate = 0d;
        //查询列表数据
        List<FuturesDO> futuresList = futuresService.likeList(params);
        Long days;
        Calendar calendar = Calendar.getInstance();
        //涨跌标识
        int flag = 0;
        List<FuturesDO> futuresChaos = new ArrayList<FuturesDO>();//特殊
        for (int i = 1; i < futuresList.size(); i++) {
            days = (futuresList.get(i).getTime().getTime() - futuresList.get(i - 1).getTime().getTime()) / (24 * 60 * 60 * 1000);
            //波幅
            Double range = futuresList.get(i - 1).getHighest() - futuresList.get(i - 1).getLowest();
            //止损点
            Double lossStop = 1200d;

            if (days < 10) {
                //上涨趋势
                if (futuresList.get(i).getHighest() - futuresList.get(i).getOpening() > range) {
                    flag = 1;
                    totalTimes++;
                    for (int j = i + 1; i < futuresList.size(); i++) {
                        Double singleProfit = futuresList.get(j).getOpening() - futuresList.get(i).getOpening() - range;
                        if (singleProfit > 0) {
                            grossProfit = grossProfit + singleProfit; // 毛利润
                            profitTimes++; //获利次数
                            if (singleProfit > singleProfitMax) {
                                singleProfitMax = singleProfit;
                            }
                        }
                    }
                }
                //下涨趋势
                if (futuresList.get(i).getOpening() - futuresList.get(i).getLowest() > range) {
                    totalTimes++;
                    if (flag == 1) {
                        futuresChaos.add(futuresList.get(i));
                    }
                    for (int j = i + 1; i < futuresList.size(); i++) {
                        if (futuresList.get(j).getOpening() < futuresList.get(i).getOpening() - range) {
                            profitTimes++;

                        }

                    }
                }
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
