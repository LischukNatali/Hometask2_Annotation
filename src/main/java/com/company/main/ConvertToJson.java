package com.company.main;

import com.company.main.annotations.CustomDateFormat;
import com.company.main.annotations.JsonValue;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//  Example:
//{ "firstName":    "Ivan",
//  "lastName":     "Ivanov",
//  "fun":          "Guitar",
//  "birthDate":    "01091990" }

public class ConvertToJson {
    public void toJson(Object o) throws IllegalAccessException {
        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("{");
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonValue.class)) {
                JsonValue annotationJsonValue = field.getAnnotation(JsonValue.class);
                System.out.println("\"" + annotationJsonValue.name() + "\": " + field.get(o) + "\", ");
            } else if (field.isAnnotationPresent(CustomDateFormat.class)) {
                CustomDateFormat annotationCustomDateFormat = field.getAnnotation(CustomDateFormat.class);
                LocalDate localDate = (LocalDate) field.get(o);
                System.out.println("\"" + field.getName() + "\": " + localDate.format(DateTimeFormatter.ofPattern(annotationCustomDateFormat.format()))  + "\", ");
            } else {
                System.out.println("\"" + field.getName() + "\": " + field.get(o) + "\", ");
            }
        }
        System.out.println("}");
    }
}
