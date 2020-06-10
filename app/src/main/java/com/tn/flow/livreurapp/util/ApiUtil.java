package com.tn.flow.livreurapp.util;


public class ApiUtil {

    private static final String BASE_URL = " http://10.0.2.2:8081/SpringMVC/servlet";

    public static RetrofitInterface getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }


}