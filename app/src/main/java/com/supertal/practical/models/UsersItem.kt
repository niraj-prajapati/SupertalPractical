package com.supertal.practical.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsersItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String
) : Serializable