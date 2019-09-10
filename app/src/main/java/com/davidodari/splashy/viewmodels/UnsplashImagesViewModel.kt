package com.davidodari.splashy.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.davidodari.splashy.api.UnsplashClient
import com.davidodari.splashy.data.UnsplashDataSource
import com.davidodari.splashy.domain.Photo

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
class UnsplashImagesViewModel : ViewModel() {

    private var photoList: LiveData<PagedList<Photo>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(false)
            .build()
        photoList = initializedPagedListBuilder(config).build()
    }

    /**
     * Retrieves data from the data source and is served as a live data paged list
     */
    fun getImages(): LiveData<PagedList<Photo>> = photoList

    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<Int, Photo> {

        val dataSourceFactory = object : DataSource.Factory<Int, Photo>() {
            override fun create(): DataSource<Int, Photo> {
                return UnsplashDataSource(UnsplashClient.getInstance())
            }
        }
        return LivePagedListBuilder<Int, Photo>(dataSourceFactory, config)
    }
}