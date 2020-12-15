package com.bootdo.futures.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-11-23 17:55:53
 */
public class FuturesDO implements Serializable {
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
    //均线1
    private Double maMa1;
    //均线2
    private Double maMa2;
    //均线3
    private Double maMa3;
    //均线4
    private Double maMa4;
    //均线5
    private Double maMa5;
    //均线6
    private Double maMa6;
    //均线7
    private Double maMa7;
    //均线8
    private Double maMa8;
    //VOL.成交量
    private Integer volVolume;
    //成交量均线1
    private Double volMavol1;
    //成交量均线2
    private Double volMavol2;
    //DIF
    private Double macdDif;
    //DEA
    private Double macdDea;
    //MACD
    private Double macdMacd;

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
     * 设置：均线1
     */
    public void setMaMa1(Double maMa1) {
        this.maMa1 = maMa1;
    }

    /**
     * 获取：均线1
     */
    public Double getMaMa1() {
        return maMa1;
    }

    /**
     * 设置：均线2
     */
    public void setMaMa2(Double maMa2) {
        this.maMa2 = maMa2;
    }

    /**
     * 获取：均线2
     */
    public Double getMaMa2() {
        return maMa2;
    }

    /**
     * 设置：均线3
     */
    public void setMaMa3(Double maMa3) {
        this.maMa3 = maMa3;
    }

    /**
     * 获取：均线3
     */
    public Double getMaMa3() {
        return maMa3;
    }

    /**
     * 设置：均线4
     */
    public void setMaMa4(Double maMa4) {
        this.maMa4 = maMa4;
    }

    /**
     * 获取：均线4
     */
    public Double getMaMa4() {
        return maMa4;
    }

    /**
     * 设置：均线5
     */
    public void setMaMa5(Double maMa5) {
        this.maMa5 = maMa5;
    }

    /**
     * 获取：均线5
     */
    public Double getMaMa5() {
        return maMa5;
    }

    /**
     * 设置：均线6
     */
    public void setMaMa6(Double maMa6) {
        this.maMa6 = maMa6;
    }

    /**
     * 获取：均线6
     */
    public Double getMaMa6() {
        return maMa6;
    }

    /**
     * 设置：均线7
     */
    public void setMaMa7(Double maMa7) {
        this.maMa7 = maMa7;
    }

    /**
     * 获取：均线7
     */
    public Double getMaMa7() {
        return maMa7;
    }

    /**
     * 设置：均线8
     */
    public void setMaMa8(Double maMa8) {
        this.maMa8 = maMa8;
    }

    /**
     * 获取：均线8
     */
    public Double getMaMa8() {
        return maMa8;
    }

    /**
     * 设置：VOL.成交量
     */
    public void setVolVolume(Integer volVolume) {
        this.volVolume = volVolume;
    }

    /**
     * 获取：VOL.成交量
     */
    public Integer getVolVolume() {
        return volVolume;
    }

    /**
     * 设置：成交量均线1
     */
    public void setVolMavol1(Double volMavol1) {
        this.volMavol1 = volMavol1;
    }

    /**
     * 获取：成交量均线1
     */
    public Double getVolMavol1() {
        return volMavol1;
    }

    /**
     * 设置：成交量均线2
     */
    public void setVolMavol2(Double volMavol2) {
        this.volMavol2 = volMavol2;
    }

    /**
     * 获取：成交量均线2
     */
    public Double getVolMavol2() {
        return volMavol2;
    }

    /**
     * 设置：DIF
     */
    public void setMacdDif(Double macdDif) {
        this.macdDif = macdDif;
    }

    /**
     * 获取：DIF
     */
    public Double getMacdDif() {
        return macdDif;
    }

    /**
     * 设置：DEA
     */
    public void setMacdDea(Double macdDea) {
        this.macdDea = macdDea;
    }

    /**
     * 获取：DEA
     */
    public Double getMacdDea() {
        return macdDea;
    }

    /**
     * 设置：MACD
     */
    public void setMacdMacd(Double macdMacd) {
        this.macdMacd = macdMacd;
    }

    /**
     * 获取：MACD
     */
    public Double getMacdMacd() {
        return macdMacd;
    }
}
