package com.example.sampleretrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts/1")
    fun getModel() : Call<Model>
}