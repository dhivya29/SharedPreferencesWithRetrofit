package com.example.dhiviya.dhivya;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetroClient {
    private static final String Base_Url = "http://temp1.pickzy.com/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}

