package com.davidodari.splashy.domain

/**
 * Created By David Odari
 * On 25/08/19
 *
 **/
data class User(
    val id: String,
    val username: String,
    val name: String,
    val first_name: String,
    val last_name: String,
    val bio: String,
    val location: String,
    val profileImage: ProfileImage
)

data class ProfileImage(
    val small: String,
    val medium: String,
    val large: String
)