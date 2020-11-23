package com.bootdo.features.domain;

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
    private Float opening;
    //最高
    private Float highest;
    //最低
    private Float lowest;
    //收盘
    private Float closing;
    //成交量
    private Integer volume;
    //均线1
    private Float maMa1;
    //均线2
    private Float maMa2;
    //均线3
    private Float maMa3;
    //均线4
    private Float maMa4;
    //均线5
    private Float maMa5;
    //均线6
    private Float maMa6;
    //均线7
    private Float maMa7;
    //均线8
    private Float maMa8;
    //VOL.成交量
    private Integer volVolume;
    //成交量均线1
    private Float volMavol1;
    //成交量均线2
    private Float volMavol2;
    //DIF
    private Float macdDif;
    //DEA
    private Float macdDea;
    //MACD
    private Float macdMacd;

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
    public void setOpening(Float opening) {
        this.opening = opening;
    }

    /**
     * 获取：开盘
     */
    public Float getOpening() {
        return opening;
    }

    /**
     * 设置：最高
     */
    public void setHighest(Float highest) {
        this.highest = highest;
    }

    /**
     * 获取：最高
     */
    public Float getHighest() {
        return highest;
    }

    /**
     * 设置：最低
     */
    public void setLowest(Float lowest) {
        this.lowest = lowest;
    }

    /**
     * 获取：最低
     */
    public Float getLowest() {
        return lowest;
    }

    /**
     * 设置：收盘
     */
    public void setClosing(Float closing) {
        this.closing = closing;
    }

    /**
     * 获取：收盘
     */
    public Float getClosing() {
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
    public void setMaMa1(Float maMa1) {
        this.maMa1 = maMa1;
    }

    /**
     * 获取：均线1
     */
    public Float getMaMa1() {
        return maMa1;
    }

    /**
     * 设置：均线2
     */
    public void setMaMa2(Float maMa2) {
        this.maMa2 = maMa2;
    }

    /**
     * 获取：均线2
     */
    public Float getMaMa2() {
        return maMa2;
    }

    /**
     * 设置：均线3
     */
    public void setMaMa3(Float maMa3) {
        this.maMa3 = maMa3;
    }

    /**
     * 获取：均线3
     */
    public Float getMaMa3() {
        return maMa3;
    }

    /**
     * 设置：均线4
     */
    public void setMaMa4(Float maMa4) {
        this.maMa4 = maMa4;
    }

    /**
     * 获取：均线4
     */
    public Float getMaMa4() {
        return maMa4;
    }

    /**
     * 设置：均线5
     */
    public void setMaMa5(Float maMa5) {
        this.maMa5 = maMa5;
    }

    /**
     * 获取：均线5
     */
    public Float getMaMa5() {
        return maMa5;
    }

    /**
     * 设置：均线6
     */
    public void setMaMa6(Float maMa6) {
        this.maMa6 = maMa6;
    }

    /**
     * 获取：均线6
     */
    public Float getMaMa6() {
        return maMa6;
    }

    /**
     * 设置：均线7
     */
    public void setMaMa7(Float maMa7) {
        this.maMa7 = maMa7;
    }

    /**
     * 获取：均线7
     */
    public Float getMaMa7() {
        return maMa7;
    }

    /**
     * 设置：均线8
     */
    public void setMaMa8(Float maMa8) {
        this.maMa8 = maMa8;
    }

    /**
     * 获取：均线8
     */
    public Float getMaMa8() {
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
    public void setVolMavol1(Float volMavol1) {
        this.volMavol1 = volMavol1;
    }

    /**
     * 获取：成交量均线1
     */
    public Float getVolMavol1() {
        return volMavol1;
    }

    /**
     * 设置：成交量均线2
     */
    public void setVolMavol2(Float volMavol2) {
        this.volMavol2 = volMavol2;
    }

    /**
     * 获取：成交量均线2
     */
    public Float getVolMavol2() {
        return volMavol2;
    }

    /**
     * 设置：DIF
     */
    public void setMacdDif(Float macdDif) {
        this.macdDif = macdDif;
    }

    /**
     * 获取：DIF
     */
    public Float getMacdDif() {
        return macdDif;
    }

    /**
     * 设置：DEA
     */
    public void setMacdDea(Float macdDea) {
        this.macdDea = macdDea;
    }

    /**
     * 获取：DEA
     */
    public Float getMacdDea() {
        return macdDea;
    }

    /**
     * 设置：MACD
     */
    public void setMacdMacd(Float macdMacd) {
        this.macdMacd = macdMacd;
    }

    /**
     * 获取：MACD
     */
    public Float getMacdMacd() {
        return macdMacd;
    }
}
