package com.FIS.Quocdb.util;
import io.github.cdimascio.dotenv.Dotenv;
public class EnvUtil {

    private static Dotenv dotenv;
    public static Dotenv dotenv(){
        if(dotenv == null){
            dotenv = Dotenv.configure().filename("src/main/.env").load();
        }
        return dotenv;
    }

    public static String get(String key) {
        return dotenv().get(key);
    }
}