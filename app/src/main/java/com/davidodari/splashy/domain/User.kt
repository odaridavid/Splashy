package com.davidodari.splashy.domain

import com.google.gson.annotations.SerializedName

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
data class User(
    @SerializedName("id") val id: String,
    @SerializedName("username") val username: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("first_name") val firstName: String?,
    @SerializedName("last_name") val lastName: String?,
    @SerializedName("bio") val bio: String?,
    @SerializedName("location") val location: String?,
    @SerializedName("profile_image") val profileImage: ProfileImage?
)

data class ProfileImage(
    val small: String?,
    val medium: String?,
    val large: String?
)