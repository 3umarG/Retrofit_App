package com.example.sampleretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("posts/{id}")
    fun getModel(@Path("id") id : Int) : Call<Model>
}