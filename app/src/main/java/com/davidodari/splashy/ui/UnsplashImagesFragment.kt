package com.davidodari.splashy.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.davidodari.splashy.R
import com.davidodari.splashy.adapter.UnsplashPhotosAdapter
import com.davidodari.splashy.viewmodels.UnsplashImagesViewModel
import kotlinx.android.synthetic.main.fragment_unsplash_images.view.*


/**
 * A simple [Fragment] subclass.
 */
class UnsplashImagesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_unsplash_images, container, false)
        val viewModel: UnsplashImagesViewModel by viewModels()

        val unsplashPhotosAdapter = UnsplashPhotosAdapter()
        view.unsplash_images_recycler_view.adapter = unsplashPhotosAdapter
        val columnCount = resources.getInteger(R.integer.list_column_count)
        view.unsplash_images_recycler_view.layoutManager =
            StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL)

        viewModel.getImages().observe(this, Observer { pagedImagesList ->
            unsplashPhotosAdapter.submitList(pagedImagesList)
        })
        return view
    }

}
