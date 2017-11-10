package com.example.dhiviya.dhivya;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

interface ApiService {
    @GET("interview_pickzy/interview.json")
    Call<Json> getMyJSON();

}