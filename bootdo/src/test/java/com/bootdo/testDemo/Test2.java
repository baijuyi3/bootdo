package com.bootdo.testDemo;

import com.fasterxml.jackson.annotation.aj;
import com.stock4j.core.b;
import com.stock4j.core.c;
import com.stock4j.core.exception.d;
import com.stock4j.pobo.PoboStock;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        try {
            List<c> ticks = test2(null, null, null, null);
            System.out.println(ticks);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.stock4j.core.exception.d d) {
            d.printStackTrace();
        }
    }

    protected final static List<c> test2(PoboStock stock, b period, LocalDateTime start, LocalDateTime end) throws IOException, com.stock4j.core.exception.d {
        File srcfile = new File("D:\\Program Files\\交易\\中粮期货-博易云交易版\\pobo5\\data\\DLYPSPZS\\min5\\020190.mi2");
        List<c> ticks = new ArrayList();
        FileInputStream fis = null;
        boolean var16 = false;

        try {
            var16 = true;
            fis = new FileInputStream(srcfile);
            byte[] b = new byte[48];

            while (true) {
                if (fis.read(b) == -1) {
                    var16 = false;
                    break;
                }

                c tick = new c();
                byte[] var7;
                int var8;
                int var9 = (var8 = aj.c(Arrays.copyOfRange(var7 = Arrays.copyOfRange(b, 0, 4), 2, 4))) / 16;
                var8 %= 16;
                int var24;
                int var10 = (var24 = aj.c(Arrays.copyOfRange(var7, 0, 2))) / 2048;
                int var11 = var24 % 2048 / 64;
                var24 = var24 % 2048 % 64;
                LocalDateTime dateTime = LocalDateTime.of(var9, var8, var10, var11, var24);
                if ((start == null || !dateTime.isBefore(start)) && (end == null || !dateTime.isAfter(end))) {
                    tick.a(dateTime);
                    tick.d((double) b(Arrays.copyOfRange(b, 4, 8)) / 1000.0D);
                    tick.a((double) b(Arrays.copyOfRange(b, 8, 12)) / 1000.0D);
                    tick.b((double) b(Arrays.copyOfRange(b, 12, 16)) / 1000.0D);
                    tick.c((double) b(Arrays.copyOfRange(b, 16, 20)) / 1000.0D);
                    tick.a((long) a(Arrays.copyOfRange(b, 20, 28)));
                    tick.b((long) b(Arrays.copyOfRange(b, 28, 32)));
                    tick.e((double) Float.intBitsToFloat((int) ((long) ((int) ((long) ((int) ((long) ((var7 = Arrays.copyOfRange(b, 32, 36))[0] & 255) | (long) var7[1] << 8) & '\uffff') | (long) var7[2] << 16) & 16777215) | (long) var7[3] << 24)));
                    tick.f((double) aj.b(Arrays.copyOfRange(b, 36, 40)) / 1000.0D);
                    ticks.add(tick);
                }
            }
        } catch (IOException var19) {
            throw var19;
        } finally {
            if (var16) {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException var17) {
                        var17.printStackTrace();
                    }
                }

            }
        }

        try {
            fis.close();
        } catch (IOException var18) {
            var18.printStackTrace();
        }

        return ticks;
    }


    public static int b(byte[] b) {
        return b[0] & 255 | (b[1] & 255) << 8 | (b[2] & 255) << 16 | (b[3] & 255) << 24;
    }

    public static double a(byte[] arr) {
        long value = 0L;

        for (int i = 0; i < 8; ++i) {
            value |= (long) (arr[i] & 255) << i * 8;
        }

        return Double.longBitsToDouble(value);
    }
}
