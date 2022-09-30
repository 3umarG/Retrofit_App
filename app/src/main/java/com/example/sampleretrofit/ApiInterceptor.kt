package com.example.sampleretrofit

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization","5555")
            .addHeader("Platform","Android")
            .addHeader("Token","skjdwjdijwijksjdksjkff")
            .build()

        return chain.proceed(request)
    }
}