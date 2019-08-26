package com.davidodari.splashy.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.davidodari.splashy.R
import com.davidodari.splashy.customview.SplashyImageView
import com.davidodari.splashy.domain.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.unsplash_photo_list_item.view.*

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
class UnsplashPhotosAdapter :
    PagedListAdapter<Photo, UnsplashPhotosAdapter.PhotoViewHolder>(PhotoDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.unsplash_photo_list_item,
                    parent,
                    false
                )
        )

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position)?.let { photo ->
            holder.unsplashImageView.aspectRatio = photo.height.toDouble() / photo.width.toDouble()
            holder.itemView.setBackgroundColor(Color.parseColor(photo.color))
            holder.likes.text = photo.likes.toString()
            holder.unsplashUsernameTextView.text = photo.user.name
            Picasso.get()
                .load(photo.urls.small)
                .into(holder.unsplashImageView)
        }
    }

    inner class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val unsplashImageView: SplashyImageView = view.list_item_splashy_image_view
        val unsplashUsernameTextView: TextView = view.list_item_username_text_view
        val likes: TextView = view.list_item_likes_text_view
    }


    companion object {
        val PhotoDiffCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem == newItem
            }
        }
    }
}