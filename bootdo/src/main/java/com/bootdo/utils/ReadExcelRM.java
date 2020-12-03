package com.bootdo.utils;

import com.bootdo.BootdoApplication;
import com.bootdo.futures.dao.FuturesDao;
import com.bootdo.futures.domain.FuturesDO;
import com.csvreader.CsvReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.STRING;

@Component
public class ReadExcelRM implements ApplicationContextAware {

    @Autowired
    private static FuturesDao futuresService;

    public static ApplicationContext context = null;
    private static FuturesDO futures = new FuturesDO();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.futuresService = applicationContext.getBean(FuturesDao.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BootdoApplication.class, args);

        List<String> files = new ArrayList<String>();
        File file = new File("D:\\Program Files\\交易\\数据");
        File[] tempList = file.listFiles();

        if (file.isDirectory()) {
            for (int i = 0; i < tempList.length; i++) {
                String extString = tempList[i].toString().substring(tempList[i].toString().lastIndexOf("."));
                System.out.println(tempList[i].toString());
                files.add(tempList[i].toString());
                if (".xlsx".equals(extString) || ".xls".equals(extString)) {
                    readExcel(tempList[i].toString());
                } else if (".txt".equals(extString)) {
                    readTxt(tempList[i].toString());
                }
            }
        }


//        readTxt("D:\\Program Files\\交易\\数据\\datahistory2010.txt");
//        readExcel("D:\\Program Files\\交易\\数据\\RM2015.xls");
    }

    private static void readTxt(String filePath) {
        try {
//            FileReader fileReader = new FileReader(filePath);
            InputStreamReader fileReader = new InputStreamReader(new FileInputStream(filePath), "GBK");
            BufferedReader buf = new BufferedReader(fileReader);

            int i = 0;
            int tranCodeNumber = 0;
            String readLine = "";
            String[] trans = new String[20];
            while ((readLine = buf.readLine()) != null) {

                    System.out.println(readLine);
                    trans = readLine.split("\\\t\\|");

                    if (tranCodeNumber != 0) {
                        try {
                            futures.setTime(simpleDateFormat.parse(trans[tranCodeNumber - 1].split("\\|")[0].replaceAll("-", "")));
                            futures.setTrancode(trans[tranCodeNumber - 1].split("\\|")[1]);
                            futures.setOpening(Float.parseFloat(trans[tranCodeNumber + 1].replaceAll(",", "")));
                            futures.setHighest(Float.parseFloat(trans[tranCodeNumber + 2].replaceAll(",", "")));
                            futures.setLowest(Float.parseFloat(trans[tranCodeNumber + 3].replaceAll(",", "")));
                            futures.setClosing(Float.parseFloat(trans[tranCodeNumber + 4].replaceAll(",", "")));
                            futures.setVolume(Integer.parseInt(trans[tranCodeNumber + 8].replaceAll(",", "")));
                            futuresService.save(futures);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (tranCodeNumber == 0) {
                        for (int c = tranCodeNumber; c < trans.length; c++) {
                            if (trans[c] != null && trans[c].equals("品种月份")) {
                                tranCodeNumber = c;
                            }
                        }
                    }
                }
                i++;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //读取excel
    public static Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        int row_total = sheet.getPhysicalNumberOfRows();
        int tranCodeNumber = 0;
        for (int j = 0; j < row_total; j++) {
            if (j <= 200000) {
                Row row = sheet.getRow(j);
                if (tranCodeNumber != 0) {
                    try {
                        futures.setTrancode(row.getCell(tranCodeNumber).getRichStringCellValue().getString());
                        futures.setTime(simpleDateFormat2.parse(row.getCell(tranCodeNumber - 1).getRichStringCellValue().getString()));
                        futures.setOpening(Float.parseFloat(row.getCell(tranCodeNumber + 2).getRichStringCellValue().getString().replaceAll(",", "")));
                        futures.setHighest(Float.parseFloat(row.getCell(tranCodeNumber + 3).getRichStringCellValue().getString().replaceAll(",", "")));
                        futures.setLowest(Float.parseFloat(row.getCell(tranCodeNumber + 4).getRichStringCellValue().getString().replaceAll(",", "")));
                        futures.setClosing(Float.parseFloat(row.getCell(tranCodeNumber + 5).getRichStringCellValue().getString().replaceAll(",", "")));
                        futures.setVolume(Integer.parseInt(row.getCell(tranCodeNumber + 9).getRichStringCellValue().getString().replaceAll(",", "")));
                        futuresService.save(futures);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (tranCodeNumber == 0) {
                    for (int c = tranCodeNumber; c < row.getPhysicalNumberOfCells(); c++) {
                        System.out.printf(row.getCell(c).getRichStringCellValue().getString());
                        if (row.getCell(c).getCellTypeEnum() == STRING && row.getCell(c).getRichStringCellValue().getString().equals("品种代码")) {
                            tranCodeNumber = c;
                        }
                    }
                    System.out.println();
                }

                System.out.println("");
            }
        }

        return wb;
    }
}
