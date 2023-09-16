package com.daffa.minimisi.presentation.gigDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.data.model.GigModelResponse
import com.daffa.minimisi.domain.model.Gig
import com.daffa.minimisi.domain.usecase.IGigUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GigDetailViewModel(
    private val gigUseCase: IGigUseCase
): ViewModel() {

    private val _gig = mutableStateOf(GigModelResponse(item = null, key = null))
    val gig: State<GigModelResponse> = _gig

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    fun getNearbyGigsById(id: String) {
        viewModelScope.launch {
            gigUseCase.getNearbyGigsById(id).collect {
                when (it) {
                    is Resource.Success -> {
                        _gig.value = it.data!!
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        _gig.value = GigModelResponse(item = null, key = null)
                        _isLoading.value = false
                    }
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                }
            }
        }
    }
}