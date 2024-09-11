package com.company.Shousi.JUC;



import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDateFormate {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i < 50; i++){
            new Thread(()->{
                synchronized (sdf){
                    try {
                        System.out.println(sdf.parse("2000-02-28"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
