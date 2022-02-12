package com.supertal.practical.data

import android.util.Log
import com.supertal.practical.models.Result
import com.supertal.practical.models.Users
import com.supertal.practical.network.APIService
import com.supertal.practical.utils.Const
import com.supertal.practical.utils.ErrorUtils
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class UsersRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {

    /**
     * fetch users from server
     */
    suspend fun fetchUsers(): Result<Users> {
        val apiService = retrofit.create(APIService::class.java)
        return getResponse(
            request = { apiService.getUsers() },
            defaultErrorMessage = "Error fetching Users"
        )
    }

    /**
     * extension function to get response
     * @param request - api request to call
     * @param defaultErrorMessage - default error message
     */
    private suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): Result<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())
            } else {
                val errorResponse = ErrorUtils.parseError(result, retrofit)
                Result.error(errorResponse?.status_message ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Log.e(Const.TAG, "getResponse: $e")
            Result.error("Unknown Error", null)
        }
    }
}