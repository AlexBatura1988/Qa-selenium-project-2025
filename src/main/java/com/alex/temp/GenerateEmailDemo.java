package com.alex.temp;

import java.util.Date;

public class GenerateEmailDemo {

    public String GenerateEmail() {
        return new Date().toString().replaceAll(" ", "").replaceAll(":", "") + "@gmail.com";
    }

}
