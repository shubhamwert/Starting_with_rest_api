package com.stechapps.restapiintegration;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PredictApi {
    @Headers("Content-type: application/json")
    @POST("/api")
    Call<Ressponse> Predict(@Body JsonObject body );

}
