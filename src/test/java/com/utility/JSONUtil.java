package com.utility;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtil {

    public static Environment readJson(Env env) {
        Gson gson = new Gson();
        FileReader fileReader;
        Config config;
        Environment environment = null;
        File jsonFile = null;
        try {
            jsonFile = new File("src/test/resources/config/config.json");
            fileReader = new FileReader(jsonFile);
            config = gson.fromJson(fileReader, Config.class);
            environment = config.getEnvironments().get(env.toString());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return environment;
    }
}
