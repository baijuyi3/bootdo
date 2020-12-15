package com.bootdo.utils;

import com.bootdo.BootdoApplication;
import com.bootdo.futures.dao.FuturesDao;
import com.bootdo.futures.domain.FuturesDO;
import com.bootdo.futures.service.FuturesService;


import com.csvreader.CsvReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

@Component
public class ReadExcel implements ApplicationContextAware {

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

        File file = new File("D:\\Program Files\\交易\\数据\\豆粕");
        File[] tempList = file.listFiles();

        if (file.isDirectory()) {
            for (int i = 0; i < tempList.length; i++) {
                String extString = tempList[i].toString().substring(tempList[i].toString().lastIndexOf("."));
                System.out.println(tempList[i].toString());
                if (".csv".equals(extString)) {
                    readCsvFile(tempList[i].toString());
                } else if (".xlsx".equals(extString) || ".xls".equals(extString)) {
                    readExcel(tempList[i].toString());
                }
            }
        }
//        readCsvFile("D:\\Program Files\\交易\\数据\\豆粕\\2018011113522038255.csv");
//        String filePath = "D:\\Program Files\\交易\\数据\\豆粕\\2020030415214926535.xlsx";
//        Workbook wb = null;
//        wb = readExcel(filePath);

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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        int row_total = sheet.getPhysicalNumberOfRows();
        int tranCodeNumber = 0;
        for (int j = 0; j < row_total; j++) {
            if (j <= 20000) {
                Row row = sheet.getRow(j);
                if (tranCodeNumber != 0) {
                    try {
                        futures.setTrancode(row.getCell(tranCodeNumber).getRichStringCellValue().getString());
                        futures.setTime(simpleDateFormat.parse(row.getCell(tranCodeNumber + 1).getRichStringCellValue().getString()));
                        futures.setOpening((Double) row.getCell(tranCodeNumber + 4).getNumericCellValue());
                        futures.setHighest((Double) row.getCell(tranCodeNumber + 5).getNumericCellValue());
                        futures.setLowest((Double) row.getCell(tranCodeNumber + 6).getNumericCellValue());
                        futures.setClosing((Double) row.getCell(tranCodeNumber + 7).getNumericCellValue());
                        futures.setVolume((int) row.getCell(tranCodeNumber + 11).getNumericCellValue());
                        futures.setVolVolume((int) row.getCell(tranCodeNumber + 13).getNumericCellValue());
                        futuresService.save(futures);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (tranCodeNumber == 0) {
                    for (int c = tranCodeNumber; c < row.getPhysicalNumberOfCells(); c++) {

                        if (row.getCell(c).getCellTypeEnum() == STRING && row.getCell(c).getRichStringCellValue().getString().equals("合约")) {
                            tranCodeNumber = c;
                        }
                    }
                }

                System.out.println("");
            }
        }

        return wb;
    }


    public static void readCsvFile(String filePath) {
        try {
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("GBK"));
//          reader.readHeaders(); //跳过表头,不跳可以注释掉

            while (reader.readRecord()) {
                csvList.add(reader.getValues()); //按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数：" + csvList.size());
            int tranCodeNumber = 0;
            for (int i = 0; i < csvList.size(); i++) {
                if (i <= 20000) {
                    if (tranCodeNumber != 0) {
                        try {
                            futures.setTrancode(csvList.get(i)[tranCodeNumber]);
                            futures.setTime(simpleDateFormat.parse(csvList.get(i)[tranCodeNumber + 1]));
                            futures.setOpening(Double.parseDouble(csvList.get(i)[tranCodeNumber + 4]));
                            futures.setHighest(Double.parseDouble(csvList.get(i)[tranCodeNumber + 5]));
                            futures.setLowest(Double.parseDouble(csvList.get(i)[tranCodeNumber + 6]));
                            futures.setClosing(Double.parseDouble(csvList.get(i)[tranCodeNumber + 7]));
                            futures.setVolume(Integer.parseInt(csvList.get(i)[tranCodeNumber + 11]));
                            futures.setVolVolume(Integer.parseInt(csvList.get(i)[tranCodeNumber + 13]));
                            futuresService.save(futures);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (tranCodeNumber == 0) {
                        for (int c = tranCodeNumber; c < csvList.get(i).length; c++) {
                            System.out.printf(csvList.get(i)[c]);
                            if (csvList.get(i)[c].equals("合约")) {
                                tranCodeNumber = c;
                            }
                        }
                    }

                    System.out.println("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static Object getCellFormatValue(Cell cell){
//        Object cellValue = null;
//        if(cell!=null){
//            //判断cell类型
//            switch(cell.getCellTypeEnum()){
//                case  NUMERIC:{
//                    cellValue = String.valueOf(cell.getNumericCellValue());
//                    break;
//                }
//                case FORMULA:{
//                    //判断cell是否为日期格式
//                    if(DateUtil.isCellDateFormatted(cell)){
//                        //转换为日期格式YYYY-mm-dd
//                        cellValue = cell.getDateCellValue();
//                    }else{
//                        //数字
//                        cellValue = String.valueOf(cell.getNumericCellValue());
//                    }
//                    break;
//                }
//                case STRING:{
//                    cellValue = cell.getRichStringCellValue().getString();
//                    break;
//                }
//                default:
//                    cellValue = "";
//            }
//        }else{
//            cellValue = "";
//        }
//        return cellValue;
//    }

}
