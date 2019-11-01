package com.davidodari.splashy.domain

import com.google.gson.annotations.SerializedName

/**
 * Represents a single photo json structure
 */
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

/**
 * Urls to image link/location
 */
data class Urls(
    @SerializedName("small") val small: String
)