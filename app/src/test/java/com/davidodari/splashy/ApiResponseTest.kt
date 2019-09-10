package com.davidodari.splashy

import com.davidodari.splashy.api.UnsplashApiService
import com.davidodari.splashy.api.UnsplashClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Created By David Odari
 * On 26/08/19
 *
 **/
class ApiResponseTest {
    //TODO Mocking
    lateinit var unsplashService: UnsplashApiService

    /**
     * Initialize Api Service client
     */
    @Before
    fun setup() {
        unsplashService = UnsplashClient.getInstance()
    }

    /**
     * Check that images are loaded
     */
    @Test
    fun loadImagesTest() {
        val response = runBlocking { unsplashService.loadPhotos(page = 2, perPage = 10) }
        val size = response.body()?.size ?: 0
        assertTrue(size > 0)
    }

}