package com.daffa.minimisi.domain.model

import com.daffa.minimisi.presentation.util.Empty

data class User(
    val userId: String? = null,
    val username: String = String.Empty,
    val email: String = String.Empty,
    val profilePictureUrl: String? = null
)
