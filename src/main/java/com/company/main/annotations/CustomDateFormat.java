package com.company.main.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CustomDateFormat {

    String format() default ("yyyyMMdd");
}
