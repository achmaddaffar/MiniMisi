package com.daffa.minimisi.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.minimisi.presentation.util.state.TextFieldState
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

    private val _emailText = mutableStateOf(TextFieldState())
    val emailText: State<TextFieldState> = _emailText

    private val _passwordText = mutableStateOf(TextFieldState())
    val passwordText: State<TextFieldState> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    fun setEmailText(state: TextFieldState) {
        _emailText.value = state
    }

    fun setPasswordText(state: TextFieldState) {
        _passwordText.value = state
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

    fun isFieldFilled(): Boolean {
        return emailText.value.text.isNotEmpty() &&
                passwordText.value.text.isNotEmpty()
    }

    private fun isPasswordValid(): Boolean {
        val isMoreThan8Chars = passwordText.value.text.length >= 8
        if (!isMoreThan8Chars) {
            setPasswordText(
                TextFieldState(
                    text = passwordText.value.text,
                    error = "Password harus lebih dari 8 karakter"
                )
            )
            return false
        }
        return true
    }

//    fun login(email: String, password: String) {
//        if (isPasswordValid())
//            viewModelScope.launch {
//                firebaseRepository.login(
//                    email,
//                    password
//                ).collect {
//                    _loginState.value = it
//                }
//            }
//    }

    fun saveOnBoardingState(isCompleted: Boolean) {

    }
}