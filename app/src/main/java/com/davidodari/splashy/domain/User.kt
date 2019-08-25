package com.davidodari.splashy.domain

import com.google.gson.annotations.SerializedName

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
data class User(
    val id: String,
    val username: String,
    val name: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val bio: String,
    val location: String,
    @SerializedName("profile_image")
    val profileImage: ProfileImage
)

data class ProfileImage(
    val small: String,
    val medium: String,
    val large: String
)