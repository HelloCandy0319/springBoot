package com.example.demo.testYpf.interfaceTest;

public enum enumType {
    Mon("Monday"), Tue("Tuesday"), Wed("Wednesday"), Thu("Thursday"), Fri( "Friday"), Sat("Saturday"), Sun("Sunday");
    private final String day;
    private enumType(String date){
        this.day = date;
    }

    public String getDay() {
        return day;
    }
}
