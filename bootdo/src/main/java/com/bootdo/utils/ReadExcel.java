package com.bootdo.utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcel {


    public static void main(String[] args) {
        File file = new File("D:\\Program Files\\交易\\tdx\\T0002\\export");
        try {
            jxl.Workbook wb = null;
            InputStream is = new FileInputStream("D:\\Program Files\\交易\\tdx\\T0002\\export\\xx.xls");
            wb = Workbook.getWorkbook(is);

            int sheetSize = wb.getNumberOfSheets();
            Sheet sheet = wb.getSheet(0);
            int row_total = sheet.getRows();
            for (int j = 0; j < row_total; j++) {
                if (j <= 5) {
                    Cell[] cells = sheet.getRow(j);
                    for (int c = 0; c < cells.length; c++) {
                        System.out.println(cells[c].getContents());
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

    }
}
