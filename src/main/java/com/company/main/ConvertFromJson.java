package com.company.main;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertFromJson {
    public void fromJson(String json, Class clazz) throws IllegalAccessException {

//        example
//        String fromJson = "{\"firstName\":\"fName\",\"lastName\":\"lName\",\"hobby\":\"hb\", \"birthDate\":\"01012011\"}";
        Human human = new Human();
        Field[] field = clazz.getDeclaredFields();
        for (Field fields : field) {
            fields.setAccessible(true);
            if (json.contains(fields.getName())) {
                int findFieldName = (json.indexOf(fields.getName())+fields.getName().length()+3);
                String findSymbols = "\"";
                String valueField = json.substring(findFieldName, json.indexOf(findSymbols, findFieldName));
                if (fields.getName().equals("birthDate")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                    LocalDate date = LocalDate.parse(valueField, formatter);
                    fields.set(human, date);
                } else {
                    fields.set(human, json.substring(findFieldName, json.indexOf(findSymbols, findFieldName)));
                }
            }
        }
    }
}
