package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelReaderUtil {

    public static Iterator<User> readExcelFile(String fileName) {
        File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);
        XSSFWorkbook xssfWorkbook = null;
        XSSFSheet xssfSheet = null;
        List<User> userList = new ArrayList<>();
        Row row = null;
        Cell emailAddressCell = null;
        Cell passwordCell = null;
        try {
            xssfWorkbook = new XSSFWorkbook(xlsxFile);
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            Iterator<Row> rowIterator = xssfSheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                userList.add(new User(emailAddressCell.getStringCellValue(), passwordCell.getStringCellValue()));
            }
            xssfWorkbook.close();
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
