package com.bootdo.testDemo;

import com.stock4j.core.c;
import com.stock4j.wenhua.WenhuaPeriod;
import org.apache.commons.io.d;
import org.apache.commons.io.output.a;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test3wh {
    public static void main(String[] args) {
        try {
            List<c> ticks = a(null, null, null, null);
            System.out.println(ticks);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static List<c> a(File file, WenhuaPeriod period, LocalDateTime start, LocalDateTime end) throws IOException {
        file = new File("D:\\Program Files\\交易\\数据\\Data_1hour\\CZCE\\hour\\00051861.dat");
        period = period.MIN15;
        byte[] temp = org.apache.commons.io.b.f(file);
        int len = 37;
        int h_len = 0;
        String periodname;
        if ((periodname = period.name().toLowerCase()).startsWith("min") || periodname.startsWith("sec")) {
            len = 36;
            h_len = 4;
        }

        List<com.stock4j.core.c> ticks = new ArrayList();

        for (int i = h_len; i < temp.length; i += len) {
            byte[] b = Arrays.copyOfRange(temp, i, i + 36);
            com.stock4j.core.c tick = new com.stock4j.core.c();
            Instant instant = Instant.ofEpochMilli((long) i(Arrays.copyOfRange(b, 0, 4)) * 1000L);
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zone);
            if ((start == null || !dateTime.isBefore(start)) && (end == null || !dateTime.isAfter(end))) {
                tick.a(dateTime);
                tick.a(new Double((double) h(Arrays.copyOfRange(b, 4, 8))));
                tick.d(new Double((double) h(Arrays.copyOfRange(b, 8, 12))));
                tick.b(new Double((double) h(Arrays.copyOfRange(b, 12, 16))));
                tick.c(new Double((double) h(Arrays.copyOfRange(b, 16, 20))));
                tick.a((new Double((double) h(Arrays.copyOfRange(b, 20, 24)))).longValue());
                tick.e(new Double((double) h(Arrays.copyOfRange(b, 24, 28))));
                tick.f(new Double((double) h(Arrays.copyOfRange(b, 28, 32))));
                ticks.add(tick);
            }
        }

//        this.zX.c("Completed read {} tick file from {}", period.name(), file.getAbsoluteFile());
        return ticks;
    }

    public static float h(byte[] b) {
        byte var1;
        return Float.intBitsToFloat((int) ((long) ((int) ((long) ((int) ((long) ((var1 = b[0]) & 255) | (long) b[1] << 8) & '\uffff') | (long) b[2] << 16) & 16777215) | (long) b[3] << 24));
    }

    public static int i(byte[] b) {
        return b[0] & 255 | (b[1] & 255) << 8 | (b[2] & 255) << 16 | (b[3] & 255) << 24;
    }

    public static byte[] f(File file) throws IOException {
        FileInputStream in = null;

        byte[] file1;
        try {
            file1 = c(in = e(file));
        } finally {
            d.b(in);
        }

        return file1;
    }

    private static FileInputStream e(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            } else if (!file.canRead()) {
                throw new IOException("File '" + file + "' cannot be read");
            } else {
                return new FileInputStream(file);
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
    }

    public static byte[] c(InputStream input) throws IOException {
        org.apache.commons.io.output.a output = new a();
        InputStream var10000 = input;
        boolean input1 = true;
        byte[] var3 = new byte[4096];
        org.apache.commons.io.output.a var2 = output;
        input = var10000;

        int var4;
        long var14;
        for (var14 = 0L; -1 != (var4 = input.read(var3)); var14 += (long) var4) {
            var2.write(var3, 0, var4);
        }

        if (var14 > 2147483647L) {
            boolean var17 = true;
        } else {
            int var18 = (int) var14;
        }

        return output.du();
    }


}
