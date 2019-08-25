package com.davidodari.splashy.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.davidodari.splashy.api.UnsplashApiService
import com.davidodari.splashy.domain.Photo

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
class UnsplashDataSourceFactory(private val unsplashApiService: UnsplashApiService) :
    DataSource.Factory<Int, Photo>() {

    val sourceLiveData = MutableLiveData<UnsplashDataSource>()

    override fun create(): DataSource<Int, Photo> {
        val source = UnsplashDataSource(unsplashApiService)
        sourceLiveData.postValue(source)
        return source
    }

}