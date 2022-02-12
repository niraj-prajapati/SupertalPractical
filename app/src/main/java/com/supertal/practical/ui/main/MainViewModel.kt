package com.supertal.practical.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supertal.practical.data.UsersRepository
import com.supertal.practical.models.Result
import com.supertal.practical.models.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val usersRepository: UsersRepository
) : ViewModel() {

    val usersLiveData = MutableLiveData<Result<Users>>()

    /**
     * fetch users list when viewModel initialized
     */
    init {
        getUsers()
    }

    /**
     * fetch users from server
     */
    fun getUsers() {
        viewModelScope.launch {
            usersRepository.fetchUsers().collect {
                usersLiveData.value = it
            }
        }
    }
}