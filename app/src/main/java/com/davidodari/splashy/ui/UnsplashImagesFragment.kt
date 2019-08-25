package com.davidodari.splashy.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.davidodari.splashy.R
import com.davidodari.splashy.adapter.UnsplashPhotosAdapter
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
        view.unsplash_images_recycler_view.adapter = UnsplashPhotosAdapter()
        val columnCount = resources.getInteger(R.integer.list_column_count)
        view.unsplash_images_recycler_view.layoutManager =
            StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL)
        return view
    }

}
