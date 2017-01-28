package com.company.main;

import com.google.gson.Gson;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Human human = new Human("Alex", "Popov", "water", LocalDate.of(2011,11,11));
        ConvertToJson convertToJson = new ConvertToJson();
        convertToJson.toJson(human);
        ConvertFromJson convertFromJson = new ConvertFromJson();
        Gson gson = new Gson();
        String a = gson.toJson(human);
        convertFromJson.fromJson(a, Human.class);
    }
}