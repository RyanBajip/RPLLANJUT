package com.example.bajip.myapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public class APIinterface {
    @GET("kontak_android")
    Call getKontak() {
        return null;
    }

    @FormUrlEncoded
    @POST("kontak")
    Call postKontak(@Field("nama") String nama, @Field("nomor") String nomor) {
        return null;
    }

    @FormUrlEncoded
    @PUT("kontak")
    Call putKontak(@Field("id") String id,
                   @Field("nama") String nama,
                   @Field("nomor") String nomor) {
        return null;
    }

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call deleteKontak(@Field("id") String id) {
        return null;
    }
}
