package com.daffa.minimisi.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.domain.model.Gig
import com.daffa.minimisi.domain.model.User
import com.daffa.minimisi.domain.usecase.IAuthUseCase
import com.daffa.minimisi.domain.usecase.IGigUseCase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    authUseCase: IAuthUseCase,
    private val gigUseCase: IGigUseCase,
) : ViewModel() {

    private val _user = mutableStateOf(User())
    val user: State<User> = _user

    private val _userCardLoading = mutableStateOf<Boolean>(true)
    val userCardLoading: State<Boolean> = _userCardLoading

    private val _nearbyGigs = mutableStateOf<List<Gig>>(emptyList())
    val nearbyGigs: State<List<Gig>> = _nearbyGigs

    private val _nearbyGigsLoading = mutableStateOf(true)
    val nearbyGigsLoading: State<Boolean> = _nearbyGigsLoading

    init {
        viewModelScope.launch {
            authUseCase.readUser(Firebase.auth.currentUser?.email as String).collect {
                when (it) {
                    is Resource.Success -> {
                        _user.value = it.data as User
                        _userCardLoading.value = false
                    }

                    is Resource.Error -> {
                        _user.value = User(username = "ERROR")
                        _userCardLoading.value = false
                    }

                    is Resource.Loading -> {
                        _userCardLoading.value = true
                    }
                }
            }
        }

        viewModelScope.launch {
            getNearbyGigs()
        }
    }

//    fun addGig(gig: Gig) = gigUseCase.addGig(gig)

    private fun getNearbyGigs() {
        viewModelScope.launch {
            gigUseCase.getNearbyGigs().collect {
                when (it) {
                    is Resource.Success -> {
                        _nearbyGigs.value = it.data!!
                        _nearbyGigsLoading.value = false
                    }

                    is Resource.Error -> {
                        _nearbyGigs.value = emptyList()
                        _nearbyGigsLoading.value = false
                    }

                    is Resource.Loading -> {
                        _nearbyGigsLoading.value = true
                    }
                }
            }
        }
    }
}