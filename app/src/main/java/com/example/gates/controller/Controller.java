package com.example.gates.controller;

import com.example.gates.api.apiset;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    public static final String url = "https://gatesadmin.000webhostapp.com/";

    private static Controller clientobject;
    private static Retrofit retrofit;

    Controller(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

        public  static synchronized Controller getInstance(){
            if(clientobject==null)
                clientobject=new Controller();
            return clientobject;
        }
        public apiset getapi(){
           return retrofit.create(apiset.class);
        }
}
