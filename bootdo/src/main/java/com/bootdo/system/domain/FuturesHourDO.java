package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-01-06 19:38:00
 */
public class FuturesHourDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //交易代码
    private String trancode;
    //时间
    private Date time;
    //开盘
    private Double opening;
    //最高
    private Double highest;
    //最低
    private Double lowest;
    //收盘
    private Double closing;
    //成交量
    private Integer volume;
    //VOL.持仓量
    private Integer volVolume;

    /**
     * 设置：id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：id
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
     * 设置：时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取：时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置：开盘
     */
    public void setOpening(Double opening) {
        this.opening = opening;
    }

    /**
     * 获取：开盘
     */
    public Double getOpening() {
        return opening;
    }

    /**
     * 设置：最高
     */
    public void setHighest(Double highest) {
        this.highest = highest;
    }

    /**
     * 获取：最高
     */
    public Double getHighest() {
        return highest;
    }

    /**
     * 设置：最低
     */
    public void setLowest(Double lowest) {
        this.lowest = lowest;
    }

    /**
     * 获取：最低
     */
    public Double getLowest() {
        return lowest;
    }

    /**
     * 设置：收盘
     */
    public void setClosing(Double closing) {
        this.closing = closing;
    }

    /**
     * 获取：收盘
     */
    public Double getClosing() {
        return closing;
    }

    /**
     * 设置：成交量
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * 获取：成交量
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * 设置：VOL.持仓量
     */
    public void setVolVolume(Integer volVolume) {
        this.volVolume = volVolume;
    }

    /**
     * 获取：VOL.持仓量
     */
    public Integer getVolVolume() {
        return volVolume;
    }
}
