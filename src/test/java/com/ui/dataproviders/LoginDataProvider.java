package com.ui.dataproviders;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "loginDataProvider")
    public Iterator<Object[]> loginDataProvider(){
        Gson gson = new Gson();
        FileReader fileReader = null;
        File testDataFile = new File(System.getProperty("user.dir") + "\\testdata\\loginData.json");
        try {
            fileReader = new FileReader(testDataFile);
        }catch (FileNotFoundException e){
            System.err.println("File not found");
            System.err.println(e.getMessage());
        }
        TestData data =  gson.fromJson(fileReader, TestData.class);
        List<Object[]> dataToReturn = new ArrayList<>();

        for(User user :data.getData()){
            dataToReturn.add(new Object[]{user});
        }

        return dataToReturn.iterator();
    }
}
