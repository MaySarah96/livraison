package com.tn.flow.livreurapp.util;


public class ApiUtil {

    private static final String BASE_URL = "http://197.14.56.36:3000/";

    public static RetrofitInterface getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }


}