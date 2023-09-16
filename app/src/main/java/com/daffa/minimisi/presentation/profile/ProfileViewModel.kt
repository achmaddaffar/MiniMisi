package com.daffa.minimisi.presentation.profile

import androidx.lifecycle.ViewModel
import com.daffa.minimisi.domain.usecase.IAuthUseCase

class ProfileViewModel(
    private val authUseCase: IAuthUseCase
): ViewModel() {

    fun logout() = authUseCase.logout()
}