package com.example.kang.kangweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.kang.kangweather.db.City;
import com.example.kang.kangweather.db.County;
import com.example.kang.kangweather.db.Province;
import com.example.kang.kangweather.gson.Weather;
import com.example.kang.kangweather.util.Utility;

import org.litepal.crud.DataSupport;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        if(prefs.getString("weather",null)!=null){

            String weatherString1 = prefs.getString("weather",null);
            Weather weather1 = Utility.handleWeatherResponse(weatherString1);
            String weatherId1 = weather1.basic.weatherId;
            Log.e("one",weatherId1);

            /**
             * 获取县名及城市Id
             */
            List<County> countyList1 = DataSupport.where("weatherId=?",String.valueOf(weatherId1)).find(County.class);
            String countyName1=" ";
            int cityId1=0;
            for(County county:countyList1){
                countyName1=county.getCountyName();
                cityId1=county.getCityId();
            }
            Log.e("two",countyName1);
            Log.e("two",String.valueOf(cityId1));

            /**
             * 获取城市名及省Id
             */
            List<City> cityList1 = DataSupport.where("id=?",String.valueOf(cityId1)).find(City.class);
            String cityName1=" ";
            int provinceId1=0;
            for(City city:cityList1){
                cityName1=city.getCityName();
                provinceId1=city.getProvinceId();
            }
            Log.e("three",cityName1);

            /**
             * 获取省名
             */
            List<Province> provinceList1 = DataSupport.where("id=?",String.valueOf(provinceId1)).find(Province.class);
            String provinceName1=" ";
            for(Province province:provinceList1){
                provinceName1=province.getProvinceName();
            }
            Log.e("four",provinceName1);

            Intent intent = new Intent(this,WeatherActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
