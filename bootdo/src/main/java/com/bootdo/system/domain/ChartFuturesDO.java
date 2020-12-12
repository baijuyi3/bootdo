package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-13 00:31:40
 */
public class ChartFuturesDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //交易代码
    private String trancode;
    //测试时间
    private String duringTime;
    //方法id
    private Integer methodId;
    //总净利润
    private Double profit;
    //毛利润
    private Double grossProfit;
    //
    private Double grossLoss;
    //
    private Integer totalTimes;
    //
    private Integer profitTimes;
    //
    private Integer lossTimes;
    //
    private Double profitRate;
    //最大单笔盈利
    private Double singleProfitMax;
    //盈利平均盈利
    private Double singleProfitAvg;
    //最大单笔亏损
    private Double singleLossMax;
    //亏损平均亏损
    private Double singleLossAvg;
    //平均盈利/亏损比例
    private Double profitLossRate;
    //平均交易盈亏总额
    private Double profitLossAvg;
    //
    private Integer profitRunningTimes;
    //
    private Integer lossRunningTimes;
    //最大平仓亏损
    private Double lossClosingPosition;
    //账户额度下限
    private Double accountPriceLeast;
    //最大合约持有数
    private Integer maxContract;
    //账户收益率
    private Double gainRate;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：交易代码
     */
    public void setTrancode(String trancode) {
        this.trancode = trancode;
    }

    /**
     * 获取：交易代码
     */
    public String getTrancode() {
        return trancode;
    }

    /**
     * 设置：测试时间
     */
    public void setDuringTime(String duringTime) {
        this.duringTime = duringTime;
    }

    /**
     * 获取：测试时间
     */
    public String getDuringTime() {
        return duringTime;
    }

    /**
     * 设置：方法id
     */
    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    /**
     * 获取：方法id
     */
    public Integer getMethodId() {
        return methodId;
    }

    /**
     * 设置：总净利润
     */
    public void setProfit(Double profit) {
        this.profit = profit;
    }

    /**
     * 获取：总净利润
     */
    public Double getProfit() {
        return profit;
    }

    /**
     * 设置：毛利润
     */
    public void setGrossProfit(Double grossProfit) {
        this.grossProfit = grossProfit;
    }

    /**
     * 获取：毛利润
     */
    public Double getGrossProfit() {
        return grossProfit;
    }

    /**
     * 设置：
     */
    public void setGrossLoss(Double grossLoss) {
        this.grossLoss = grossLoss;
    }

    /**
     * 获取：
     */
    public Double getGrossLoss() {
        return grossLoss;
    }

    /**
     * 设置：
     */
    public void setTotalTimes(Integer totalTimes) {
        this.totalTimes = totalTimes;
    }

    /**
     * 获取：
     */
    public Integer getTotalTimes() {
        return totalTimes;
    }

    /**
     * 设置：
     */
    public void setProfitTimes(Integer profitTimes) {
        this.profitTimes = profitTimes;
    }

    /**
     * 获取：
     */
    public Integer getProfitTimes() {
        return profitTimes;
    }

    /**
     * 设置：
     */
    public void setLossTimes(Integer lossTimes) {
        this.lossTimes = lossTimes;
    }

    /**
     * 获取：
     */
    public Integer getLossTimes() {
        return lossTimes;
    }

    /**
     * 设置：
     */
    public void setProfitRate(Double profitRate) {
        this.profitRate = profitRate;
    }

    /**
     * 获取：
     */
    public Double getProfitRate() {
        return profitRate;
    }

    /**
     * 设置：最大单笔盈利
     */
    public void setSingleProfitMax(Double singleProfitMax) {
        this.singleProfitMax = singleProfitMax;
    }

    /**
     * 获取：最大单笔盈利
     */
    public Double getSingleProfitMax() {
        return singleProfitMax;
    }

    /**
     * 设置：盈利平均盈利
     */
    public void setSingleProfitAvg(Double singleProfitAvg) {
        this.singleProfitAvg = singleProfitAvg;
    }

    /**
     * 获取：盈利平均盈利
     */
    public Double getSingleProfitAvg() {
        return singleProfitAvg;
    }

    /**
     * 设置：最大单笔亏损
     */
    public void setSingleLossMax(Double singleLossMax) {
        this.singleLossMax = singleLossMax;
    }

    /**
     * 获取：最大单笔亏损
     */
    public Double getSingleLossMax() {
        return singleLossMax;
    }

    /**
     * 设置：亏损平均亏损
     */
    public void setSingleLossAvg(Double singleLossAvg) {
        this.singleLossAvg = singleLossAvg;
    }

    /**
     * 获取：亏损平均亏损
     */
    public Double getSingleLossAvg() {
        return singleLossAvg;
    }

    /**
     * 设置：平均盈利/亏损比例
     */
    public void setProfitLossRate(Double profitLossRate) {
        this.profitLossRate = profitLossRate;
    }

    /**
     * 获取：平均盈利/亏损比例
     */
    public Double getProfitLossRate() {
        return profitLossRate;
    }

    /**
     * 设置：平均交易盈亏总额
     */
    public void setProfitLossAvg(Double profitLossAvg) {
        this.profitLossAvg = profitLossAvg;
    }

    /**
     * 获取：平均交易盈亏总额
     */
    public Double getProfitLossAvg() {
        return profitLossAvg;
    }

    /**
     * 设置：
     */
    public void setProfitRunningTimes(Integer profitRunningTimes) {
        this.profitRunningTimes = profitRunningTimes;
    }

    /**
     * 获取：
     */
    public Integer getProfitRunningTimes() {
        return profitRunningTimes;
    }

    /**
     * 设置：
     */
    public void setLossRunningTimes(Integer lossRunningTimes) {
        this.lossRunningTimes = lossRunningTimes;
    }

    /**
     * 获取：
     */
    public Integer getLossRunningTimes() {
        return lossRunningTimes;
    }

    /**
     * 设置：最大平仓亏损
     */
    public void setLossClosingPosition(Double lossClosingPosition) {
        this.lossClosingPosition = lossClosingPosition;
    }

    /**
     * 获取：最大平仓亏损
     */
    public Double getLossClosingPosition() {
        return lossClosingPosition;
    }

    /**
     * 设置：账户额度下限
     */
    public void setAccountPriceLeast(Double accountPriceLeast) {
        this.accountPriceLeast = accountPriceLeast;
    }

    /**
     * 获取：账户额度下限
     */
    public Double getAccountPriceLeast() {
        return accountPriceLeast;
    }

    /**
     * 设置：最大合约持有数
     */
    public void setMaxContract(Integer maxContract) {
        this.maxContract = maxContract;
    }

    /**
     * 获取：最大合约持有数
     */
    public Integer getMaxContract() {
        return maxContract;
    }

    /**
     * 设置：账户收益率
     */
    public void setGainRate(Double gainRate) {
        this.gainRate = gainRate;
    }

    /**
     * 获取：账户收益率
     */
    public Double getGainRate() {
        return gainRate;
    }
}
