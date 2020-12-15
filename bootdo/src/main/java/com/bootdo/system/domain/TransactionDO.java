package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-15 23:49:23
 */
public class TransactionDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //交易代码
    private String trancode;
    //方法id
    private Integer methodId;
    //
    private Date time;
    //总净利润
    private Double price;
    //0-买入，1-卖出
    private Integer flag;

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
     * 设置：
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取：
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置：总净利润
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取：总净利润
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置：0-买入，1-卖出
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取：0-买入，1-卖出
     */
    public Integer getFlag() {
        return flag;
    }
}
