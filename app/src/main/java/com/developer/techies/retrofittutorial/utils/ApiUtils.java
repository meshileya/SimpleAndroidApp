package com.developer.techies.retrofittutorial.utils;

import com.developer.techies.retrofittutorial.remote.RetrofitClient;
import com.developer.techies.retrofittutorial.remote.Service;

public class ApiUtils {

    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static Service getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}
