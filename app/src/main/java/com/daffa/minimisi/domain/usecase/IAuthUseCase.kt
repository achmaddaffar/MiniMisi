package com.daffa.minimisi.domain.usecase

import com.daffa.minimisi.data.Resource
import kotlinx.coroutines.flow.Flow

interface IAuthUseCase {

    fun login(
        email: String,
        password: String
    ): Flow<Resource<String>>

    fun register(
        email: String,
        password: String
    ): Flow<Resource<String>>
}