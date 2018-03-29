package com.example.kang.kangweather.gson;

/**
 * Created by kang on 2018/3/28.
 */

public class AQI {
    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
