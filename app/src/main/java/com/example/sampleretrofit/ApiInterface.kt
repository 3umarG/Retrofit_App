package com.example.sampleretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("posts/{id}")
    fun getModel(@Path("id") id : Int) : Call<Model>

    @GET("posts")
    fun getAllPosts(@Query("id") postId : String) : Call<List<Model>>
    // TODO : put "?id" after "posts" --> posts?id=$postId
}