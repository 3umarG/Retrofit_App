package com.example.sampleretrofit

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    // TODO : GET by Resource
    @GET("posts/{id}")
    fun getModel(@Path("id") id: Int): Call<Model>


    // TODO : GET by Single Query
    @GET("posts")
    fun getAllPosts(@Query("id") postId: String): Call<List<Model>>
    // TODO : put "?id" after "posts" --> posts?id=$postId


    // TODO : GET by QueryMap : "multiple query"
    @GET("posts")
    fun getAllPostsWithQueryMap(
        @Query("id") postId: String,
        @QueryMap options: Map<String, String>
    ): Call<List<Model>>


    // TODO : POST by using Map , you can also create custom Model class to store my data then POST ...
    @POST("posts")
    fun postModel(@Body body: HashMap<Any, Any>): Call<Model>
}