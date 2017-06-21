package com.github.vivchar.immutableadapter.service;


import com.github.vivchar.immutableadapter.model.Feed2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceApi {
    @GET("api.php?type=posts_data&user_id=164")
    Call<Feed2> getAllFilms();

}
