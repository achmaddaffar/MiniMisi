package com.daffa.minimisi.data.model

import com.daffa.minimisi.presentation.util.Empty

data class AuthUser(
    val email: String? = String.Empty,
    val password: String? = String.Empty
)
