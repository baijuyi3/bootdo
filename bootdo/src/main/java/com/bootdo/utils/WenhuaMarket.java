package com.bootdo.utils;

import com.fasterxml.jackson.databind.ser.std.ah;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WenhuaMarket extends ah {
    private static Map<String, String> marketAlias;
    private String folder;
    private boolean vaild = true;

    static {
        (marketAlias = new HashMap()).put("CME", "芝加哥商品交易所");
        marketAlias.put("CBOT", "芝加哥期货交易所");
        marketAlias.put("CBOE", "芝加哥期权交易所");
        marketAlias.put("EUREX", "欧洲期货交易所");
        marketAlias.put("COMEX", "纽约商品交易所");
        marketAlias.put("CZCE", "郑州商品交易所");
        marketAlias.put("DCE", "大连商品交易所");
        marketAlias.put("SHME", "上海有色金属现货交易中心");
        marketAlias.put("SHFE", "上海期货交易所");
        marketAlias.put("SHSE", "上海证券交易所");
        marketAlias.put("SZSE", "深圳证券交易所");
        marketAlias.put("CFFEX", "金融期货交易所");
        marketAlias.put("INE", "上海国际能源交易中心");
        marketAlias.put("NYMEX", "纽约商业交易所");
        marketAlias.put("HKEX", "香港交易所");
        marketAlias.put("SGX", "新加坡交易所");
        marketAlias.put("TOCOM", "东京商品交易所");
        marketAlias.put("SICOM", "新加坡商品交易所");
        marketAlias.put("LEM", "伦敦金属交易所");
        marketAlias.put("SGE", "上海黄金交易所");
        marketAlias.put("NYJ", "纽约金");
        marketAlias.put("LDJ", "伦敦金");
        marketAlias.put("GJ", "港金");
        marketAlias.put("HKSE", "香港证券交易所");
    }

    public WenhuaMarket() {
    }

    public WenhuaMarket(String dirname) {
        this.folder = dirname;
        dirname = org.apache.commons.io.c.aP(dirname).toUpperCase();
        super.setBcode(dirname);
        if (marketAlias.containsKey(dirname)) {
            super.setBname((String) marketAlias.get(dirname));
        } else {
            super.setBname(dirname);
        }
    }

    public WenhuaMarket(String folder, String bname) {
        this.folder = folder;
        super.setBname(bname);
    }

    public WenhuaMarket(String bcode, String bname, File filePath) {
        super.setBcode(bcode);
        super.setBname(bname);
        super.setFilePath(filePath);
        this.setFolder(filePath.getAbsolutePath());
    }

    public String getFolder() {
        return this.folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public boolean isVaild() {
        return this.vaild;
    }

    public void setVaild(boolean vaild) {
        this.vaild = vaild;
    }

    public String toString() {
        return this.getBname();
    }

    public com.stock4j.core.a toMarketType() {
        com.stock4j.core.a market = null;
        String dirname;
        if ((dirname = org.apache.commons.io.c.aP(this.folder).toUpperCase()).equalsIgnoreCase("SHSE")) {
            market = com.stock4j.core.a.xD;
        } else if (dirname.equalsIgnoreCase("SZSE")) {
            market = com.stock4j.core.a.xE;
        }

        return market;
    }
}
