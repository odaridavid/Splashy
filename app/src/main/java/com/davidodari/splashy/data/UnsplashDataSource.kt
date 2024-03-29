package com.davidodari.splashy.data

import androidx.paging.PageKeyedDataSource
import com.davidodari.splashy.api.UnsplashApiService
import com.davidodari.splashy.domain.Photo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
class UnsplashDataSource(private val unsplashApiService: UnsplashApiService) :
    PageKeyedDataSource<Int, Photo>() {

    companion object {
        private const val NEXT_PAGE_INIT = 2
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Photo>
    ) {
        GlobalScope.launch {
            try {
                val response = unsplashApiService.loadPhotos(page = 1, perPage = 20)
                when {
                    response.isSuccessful -> {
                        val photoList = response.body()
                        photoList?.let {
                            callback.onResult(photoList, null, NEXT_PAGE_INIT)
                        }
                    }
                }
            } catch (e: IOException) {
                Timber.d("Data Initialisation Failed : ${e.message}")
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        GlobalScope.launch {
            try {
                Timber.d("${params.key}")
                val response =
                    unsplashApiService.loadPhotos(
                        page = params.key,
                        perPage = params.requestedLoadSize
                    )
                when {
                    response.isSuccessful -> {
                        val photoList = response.body()
                        photoList?.let {
                            callback.onResult(photoList, params.key + 1)
                        }
                    }
                }
            } catch (e: IOException) {
                Timber.d("Loading Next Set Failed : ${e.message}")
            }
        }
    }


    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        TODO("implementation")
    }

}
