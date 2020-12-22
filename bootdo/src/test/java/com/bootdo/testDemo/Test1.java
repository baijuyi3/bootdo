package com.bootdo.testDemo;

import com.stock4j.core.util.helper.LicenseGenerator;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;

public class Test1 {
    public static void main(String[] args) {
        byte[] b = new byte[]{100, 50, 104, 107, 89, 88, 82, 104, 77, 68, 69, 61};
        byte[] a = new byte[]{99, 71, 57, 105, 98, 50, 82, 104, 100, 71, 69, 61};
        System.out.println(new String(a));
        System.out.println(new String(Base64.decode(new String(a))));
        String Key = new String(Base64.decode(new String(a)));
        System.out.println(Key);
        String BR = "9A69-4007-76BE-DC8F-25C5-E5D4-50FB-DAA7";
        String rcode = "n1gB8TGEMhPYNTZ3eVMv1kYvleghNAPV+uhyYk6tFKhMYZKtKvEwmg==";
        try {
            System.out.println(i(BR, Key));
            System.out.println(j(rcode, Key));
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        com.stock4j.core.util.helper.b.mr();
//        String key = com.stock4j.core.util.helper.b.ax(new String(a));
//        rcode = "an1gB8TGEMhPYNTZ3eVMv1kYvleghNAPV+uhyYk6tFKhMYZKtKvEwmg==";
////        System.out.println(rcode.substring(1));
//        try {
//            System.out.println(LicenseGenerator.b(BR, rcode.substring(1), key));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    public static String j(String data, String key) throws IOException, Exception {
        if (data == null) {
            return null;
        } else {
            byte[] var10000 = (new BASE64Decoder()).decodeBuffer(data);
            byte[] key1 = key.getBytes();
            byte[] bt = var10000;
            SecureRandom var2 = new SecureRandom();
            DESKeySpec key2 = new DESKeySpec(key1);
            SecretKey key3 = SecretKeyFactory.getInstance("DES").generateSecret(key2);
            Cipher var3;
            (var3 = Cipher.getInstance("DES")).init(2, key3, var2);
            bt = var3.doFinal(bt);
            return new String(bt);
        }
    }

    public static String i(String data, String key) throws Exception {
        byte[] var10000 = data.getBytes();
        byte[] key1 = key.getBytes();
        byte[] bt = var10000;
        SecureRandom var2 = new SecureRandom();
        DESKeySpec key2 = new DESKeySpec(key1);
        SecretKey key3 = SecretKeyFactory.getInstance("DES").generateSecret(key2);
        Cipher var3;
        (var3 = Cipher.getInstance("DES")).init(1, key3, var2);
        bt = var3.doFinal(bt);
        return (new BASE64Encoder()).encode(bt);
    }

    private static String a(String line, String param, String charset) throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        boolean var10 = false;

        try {
            var10 = true;
            URLConnection conn;
            (conn = (new URL(line)).openConnection()).setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            (out = new PrintWriter(conn.getOutputStream())).print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

            while (true) {
                if ((line = in.readLine()) == null) {
                    var10 = false;
                    break;
                }

                result = result + line;
            }
        } catch (IOException var13) {
            throw var13;
        } finally {
            if (var10) {
                try {
                    if (out != null) {
                        out.close();
                    }

                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var11) {
                    var11.printStackTrace();
                }

            }
        }

        try {
            out.close();
            in.close();
        } catch (IOException var12) {
            var12.printStackTrace();
        }

        return result;
    }
}
