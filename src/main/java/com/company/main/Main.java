package com.company.main;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Human human = new Human("Alex", "Popov", "water", LocalDate.of(2011,11,11));
        ConvertToJson convertToJson = new ConvertToJson();
        convertToJson.toJson(human);
        ConvertFromJson convertFromJson = new ConvertFromJson();
        String fromJson = "{\"firstName\":\"fName\",\"lastName\":\"lName\",\"hobby\":\"hb\", \"birthDate\":\"19911011\"}";
        Human human2 = new Human();
        convertFromJson.fromJson(fromJson, human.getClass());
        System.out.println(human.toString());

    }
}