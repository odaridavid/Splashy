package com.davidodari.splashy.api

import com.davidodari.splashy.BuildConfig
import com.davidodari.splashy.domain.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
interface UnsplashApiService {

    @GET("photos")
    suspend fun loadPhotos(
        @Header("Authorization") auth: String? = " Client-ID ${BuildConfig.ACCESS_KEY}",
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<List<Photo>>

}