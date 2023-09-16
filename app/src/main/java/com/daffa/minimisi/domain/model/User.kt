package com.daffa.minimisi.domain.model

import com.daffa.minimisi.presentation.util.Empty

data class User(
    val userId: String? = null,
    val username: String = String.Empty,
    val profilePictureUrl: String = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZBRvbkwbqSK-6gx0QXAH_FM3FVxYXXK8CiA&usqp=CAU"
)
