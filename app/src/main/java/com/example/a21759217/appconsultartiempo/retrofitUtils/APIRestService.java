package com.example.a21759217.appconsultartiempo.retrofitUtils;

import com.example.a21759217.appconsultartiempo.pojo.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIRestService {

    public static final String BASE_URL="https://api.darksky.net/";
    public static final String KEY="11ce4328111023379e0fdc9d28c24a02";
    public static final String EXCLUDE="minutely,hourly,daily,alerts,flags";
    public static final String LANG="es";

    @GET("forecast/{key}/{latitude},{longitude}")
    Call<Weather>obtenerTiempo(@Path("key") String key,
                               @Path("latitude") String latitude,
                               @Path("longitude") String longitude,
                               @Query("exclude") String exclude,
                               @Query("lang") String lang);
}
