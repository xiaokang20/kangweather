package com.example.kang.kangweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kang on 2018/3/28.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
