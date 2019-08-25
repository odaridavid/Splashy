package com.davidodari.splashy.api

import com.davidodari.splashy.models.PhotosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
interface UnsplashApiService {

    @GET("photos")
    suspend fun loadPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10
    ): Response<PhotosResponse>

}