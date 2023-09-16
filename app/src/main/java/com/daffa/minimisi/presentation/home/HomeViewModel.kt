package com.daffa.minimisi.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.domain.model.User
import com.daffa.minimisi.domain.usecase.IAuthUseCase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(
    authUseCase: IAuthUseCase,
) : ViewModel() {

    private val _user = mutableStateOf(User())
    val user: State<User> = _user

    private val _userCardLoading = mutableStateOf<Boolean>(true)
    val userCardLoading: State<Boolean> = _userCardLoading

    init {
        viewModelScope.launch {
            authUseCase.readUser(Firebase.auth.currentUser?.email as String).collect {
                when(it) {
                    is Resource.Success -> {
                        _userCardLoading.value = false
                        _user.value = it.data as User
                    }
                    is Resource.Error -> {
                        _userCardLoading.value = false
                        _user.value = User(username = "ERROR")
                    }
                    is Resource.Loading -> {
                        Log.e("HomeViewModel", "LOADING CARD")
                        _userCardLoading.value = true
                    }
                }
            }
        }
    }
}