package com.example.kang.kangweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kang on 2018/3/28.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
