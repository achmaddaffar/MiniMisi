package com.daffa.minimisi.data.model

import com.daffa.minimisi.domain.model.User
import com.daffa.minimisi.presentation.util.Empty

data class UserModelResponse(
    val item: User?,
    val key: String? = String.Empty
)