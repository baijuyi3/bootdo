package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-12-08 21:45:19
 */
public class RuleDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //规则编号
    private Integer ruleId;
    //规则名
    private String ruleName;
    //方法
    private String method;
    //描述
    private String describe;
    //交易码
    private String trancode;
    //预留字段
    private String filler;

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
     * 设置：规则编号
     */
    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 获取：规则编号
     */
    public Integer getRuleId() {
        return ruleId;
    }

    /**
     * 设置：规则名
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    /**
     * 获取：规则名
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * 设置：方法
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取：方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置：描述
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 获取：描述
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置：交易码
     */
    public void setTrancode(String trancode) {
        this.trancode = trancode;
    }

    /**
     * 获取：交易码
     */
    public String getTrancode() {
        return trancode;
    }

    /**
     * 设置：预留字段
     */
    public void setFiller(String filler) {
        this.filler = filler;
    }

    /**
     * 获取：预留字段
     */
    public String getFiller() {
        return filler;
    }
}
