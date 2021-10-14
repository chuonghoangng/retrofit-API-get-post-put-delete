package com.example.lib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private  static Retrofit retrofit;
    private static String Base_Url = "https://android-article.herokuapp.com";//http://127.0.0.1:8088/
    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }

    

    public static String getBase_Url() {
        return Base_Url;
    }
}
