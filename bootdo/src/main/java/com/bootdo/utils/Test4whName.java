package com.bootdo.utils;

import com.fasterxml.jackson.databind.r;
import com.stock4j.core.util.helper.PinyinHelper;
import com.stock4j.wenhua.Contract;
import com.stock4j.wenhua.WenhuaMarket;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;

public class Test4whName implements ApplicationContextAware {
    private static DecimalFormat zP = new DecimalFormat("00000000");
    private static DecimalFormat zQ = new DecimalFormat("000");
    private static DecimalFormat zR = new DecimalFormat("000000");
    private static DecimalFormat zS = new DecimalFormat("00000");
    private static r zT = new r();
    private static List<String> zU;
    private org.apache.log4j.lf5.viewer.b zV = null;

    static {
        (zU = new ArrayList()).add("MKT32");
        zU.add("上证期权");
        zU.add("郑州期权");
        zU.add("上海期权");
        zU.add("大连期权");
        zU.add("中金期权");
    }


    public static void main(String[] args) {
        File cont_file = Paths.get("D:\\Program Files\\交易\\wh6中粮期货x64\\Data\\CZCE", "cont.dat").toFile();
        String mcode = org.apache.commons.io.c.aP("D:\\Program Files\\交易\\wh6中粮期货x64\\Data\\CZCE");
        WenhuaMarket market = new WenhuaMarket("D:\\Program Files\\交易\\wh6中粮期货x64");
        byte[] b_temp = new byte[0];
        try {
            b_temp = Arrays.copyOfRange(b_temp = org.apache.commons.io.b.f(cont_file), 8, b_temp.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Contract> conts = new TreeSet();

        for (int i = 0; i < b_temp.length; i += 141) {
            byte[] b = Arrays.copyOfRange(b_temp, i, i + 141);
            Contract cont = new Contract();
            float whcode;
            if ((whcode = org.slf4j.helpers.c.h(Arrays.copyOfRange(b, 4, 8))) >= 1.0F && whcode < 999999.0F) {
                String fname;
                String cname;
                if (mcode.equalsIgnoreCase("SHSE")) {
                    if ((fname = String.valueOf((int) whcode)).length() <= 3) {
                        cname = "999" + zQ.format((double) whcode);
                        cont.setWhcode(cname);
                        cont.setFile(cname);
                    } else {
                        cont.setWhcode(zR.format((double) whcode));
                        cont.setFile(fname);
                    }
                } else if (mcode.equalsIgnoreCase("SZSE")) {
                    fname = zR.format((double) whcode);
                    cont.setWhcode(fname);
                    cont.setFile(String.valueOf((int) whcode));
                } else if (mcode.equalsIgnoreCase("HKSE")) {
                    fname = zS.format((double) whcode);
                    cont.setWhcode(fname);
                    cont.setFile(String.valueOf((int) whcode));
                } else if (mcode.equalsIgnoreCase("美国股票")) {
                    cont.setWhcode(String.valueOf((int) whcode));
                    cont.setFile(cont.getWhcode());
                } else {
                    int cfile = org.slf4j.helpers.c.j(Arrays.copyOfRange(b, 8, 10));
                    cont.setFile(zP.format((long) cfile));
                    cont.setWhcode(String.valueOf((int) whcode));
                }

                try {
                    fname = (new String(Arrays.copyOfRange(b, 25, 53), "GBK")).trim();
                    cname = (new String(Arrays.copyOfRange(b, 53, 81), "GBK")).trim();
                    cont.setScode(fname.length() == 0 ? cont.getWhcode() : fname);
                    cont.setSname(cname.length() == 0 ? cont.getWhcode() : cname);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                cont.setWhmarket(market);
                cont.setAbbr(PinyinHelper.az(cont.getSname()));
                cont.setInternalCode(org.slf4j.helpers.c.j(Arrays.copyOfRange(b, 8, 10)));
                byte var12;
                cont.setMarketAndBlockCode((var12 = b[10]) & 255, (var12 = b[11]) & 255);
                conts.add(cont);
            }
        }
        System.out.println(conts);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
