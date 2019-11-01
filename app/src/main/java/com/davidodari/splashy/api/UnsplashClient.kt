package com.davidodari.splashy.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
object UnsplashClient {
    private const val BASE_URL = "https://api.unsplash.com/"

    private fun setupInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply{
       this.level = HttpLoggingInterceptor.Level.BODY
    }

    private fun setupOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(setupInterceptor())
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    /**
     * Provides UnsplashApiService interface through builder pattern
     */
    fun getInstance(): UnsplashApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(setupOkhttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UnsplashApiService::class.java)
    }
}