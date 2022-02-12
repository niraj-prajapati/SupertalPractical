package com.supertal.practical.data

import com.supertal.practical.models.Result
import com.supertal.practical.models.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor(private val usersRemoteDataSource: UsersRemoteDataSource) {

    /**
     * fetch users from server
     */
    suspend fun fetchUsers(): Flow<Result<Users>> {
        return flow {
            emit(Result.loading())
            emit(usersRemoteDataSource.fetchUsers())
        }.flowOn(Dispatchers.IO)
    }
}