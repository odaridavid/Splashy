package com.davidodari.splashy.domain

import com.google.gson.annotations.SerializedName

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
data class Photo(
    @SerializedName("id") val id: String,
    @SerializedName("width") val width: Long,
    @SerializedName("likes") val likes: Long,
    @SerializedName("height") val height: Long,
    @SerializedName("color") val color: String? = "#000",
    @SerializedName("description") val description: String?,
    @SerializedName("urls") val urls: Urls,
    @SerializedName("user") val user: User
)

data class Urls(
    @SerializedName("small") val small: String
)