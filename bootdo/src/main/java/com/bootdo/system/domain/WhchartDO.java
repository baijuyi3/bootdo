package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-01-03 22:49:09
 */
public class WhchartDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //序号
    private Integer id;
    //wh代码
    private String whcode;
    //证券代码
    private String code;
    //文件名
    private String fileName;
    //名称
    private String name;
    //缩写
    private String abbr;

    /**
     * 设置：序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：wh代码
     */
    public void setWhcode(String whcode) {
        this.whcode = whcode;
    }

    /**
     * 获取：wh代码
     */
    public String getWhcode() {
        return whcode;
    }

    /**
     * 设置：证券代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：证券代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置：文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取：文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：缩写
     */
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    /**
     * 获取：缩写
     */
    public String getAbbr() {
        return abbr;
    }
}
