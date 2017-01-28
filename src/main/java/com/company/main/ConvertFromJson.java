package com.company.main;

import com.google.gson.Gson;

public class ConvertFromJson {
    public void fromJson (String json, Class clazz){

        Gson gson = new Gson();
        gson.fromJson(json, clazz);
    }
}
