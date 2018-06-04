package com.developer.techies.retrofittutorial.remote;

import com.developer.techies.retrofittutorial.model.MyResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Service {

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Observable<MyResponse> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Observable<MyResponse> getAnswers(@Query("tagged") String tags);
}
