package com.daffa.minimisi.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.daffa.minimisi.domain.model.User
import com.daffa.minimisi.domain.usecase.IAuthUseCase
import com.daffa.minimisi.presentation.util.state.TextFieldState

class RegisterViewModel(
    private val useCase: IAuthUseCase,
) : ViewModel() {

    private val _usernameText = mutableStateOf(TextFieldState())
    val usernameText: State<TextFieldState> = _usernameText

    private val _emailText = mutableStateOf(TextFieldState())
    val emailText: State<TextFieldState> = _emailText

    private val _passwordText = mutableStateOf(TextFieldState())
    val passwordText: State<TextFieldState> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _confirmPasswordText = mutableStateOf(TextFieldState())
    val confirmPasswordText: State<TextFieldState> = _confirmPasswordText

    private val _showConfirmPassword = mutableStateOf(false)
    val showConfirmPassword: State<Boolean> = _showConfirmPassword

    fun setUsernameText(state: TextFieldState) {
        _usernameText.value = state
    }

    fun setEmailText(state: TextFieldState) {
        _emailText.value = state
    }

    fun setPasswordText(state: TextFieldState) {
        _passwordText.value = state
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

    fun setConfirmPasswordText(state: TextFieldState) {
        _confirmPasswordText.value = state
    }

    fun setShowConfirmPassword(showPassword: Boolean) {
        _showConfirmPassword.value = showPassword
    }

    fun isFieldFilled(): Boolean {
        return usernameText.value.text.isNotEmpty() &&
                passwordText.value.text.isNotEmpty() &&
                this.confirmPasswordText.value.text.isNotEmpty()
    }

    private fun isPasswordValid(): Boolean {
        val isTheSame = passwordText.value.text == this.confirmPasswordText.value.text
        val isMoreThan8Chars = passwordText.value.text.length >= 8
        if (!isTheSame) {
            setPasswordText(
                TextFieldState(
                    text = passwordText.value.text,
                    error = "Kedua password harus sama"
                )
            )
            setConfirmPasswordText(
                TextFieldState(
                    text = this.confirmPasswordText.value.text,
                    error = "Kedua password harus sama"
                )
            )
            return false
        }
        if (!isMoreThan8Chars) {
            setPasswordText(
                TextFieldState(
                    text = passwordText.value.text,
                    error = "Password harus lebih dari 8 karakter"
                )
            )
            setConfirmPasswordText(
                TextFieldState(
                    text = this.confirmPasswordText.value.text,
                    error = "Password harus lebih dari 8 karakter"
                )
            )
            return false
        }
        return true
    }

    fun register() =
        useCase.register(emailText.value.text, passwordText.value.text)

    fun addUserToDb() = useCase.addUserToDb(
        User(
            userId = null,
            username = usernameText.value.text
        )
    )
}