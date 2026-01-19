package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtil {
    public static Iterator<User> readCSVFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + "//testdata//" + fileName);
        FileReader fileReader = null;
        CSVReader csvReader = null;
        String[] line;
        List<User> userList = new ArrayList<>();
        User userData;
        try {
            fileReader = new FileReader(file);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
