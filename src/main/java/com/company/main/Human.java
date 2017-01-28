package com.company.main;

//{ "firstName":    "Ivan",
//  "lastName":     "Ivanov",
//  "fun":          "Guitar",
//  "birthDate":    "01091990" }

import com.company.main.annotations.CustomDateFormat;
import com.company.main.annotations.JsonValue;

import java.time.LocalDate;

public class Human {
     private String firstName;
     private String lastName;

    @JsonValue(name = "fun")
     private String hobby;
    @CustomDateFormat(format = "ddMMyyyy")
    private LocalDate birthDate;

    public Human(String firstName, String lastName, String hobby, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hobby='" + hobby + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
