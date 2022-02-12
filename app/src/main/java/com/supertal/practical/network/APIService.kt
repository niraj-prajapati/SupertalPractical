package com.supertal.practical.network

import com.supertal.practical.models.Users
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET(APIs.GET_USERS)
    suspend fun getUsers(): Response<Users>
}