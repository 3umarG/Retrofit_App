package com.example.sampleretrofit

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    // GET by Resource
    @GET("posts/{id}")
    fun getModel(@Path("id") id : Int) : Call<Model>

    // GET by Query
    @GET("posts")
    fun getAllPosts(@Query("id") postId : String) : Call<List<Model>>
    // TODO : put "?id" after "posts" --> posts?id=$postId


    @POST("posts")
    fun postModel(@Body body : HashMap<Any,Any>) : Call<Model>
}