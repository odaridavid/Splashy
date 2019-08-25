package com.davidodari.splashy.domain

import com.google.gson.annotations.SerializedName

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
data class Photo(
    val id: String,
    val width: Long,
    val height: Long,
    val color: String,
    val description: String,
    val user: User,
    val urls: Urls,
    val links: Links
)

data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)

data class Links(
    val self: String,
    val html: String,
    val download: String,
    @SerializedName("download_location")
    val downloadLocation: String
)