package com.daffa.minimisi.domain.repository

import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.data.model.AuthUser
import kotlinx.coroutines.flow.Flow

interface IAuthRepository {

    fun register(
        user: AuthUser
    ): Flow<Resource<String>>

    fun loginUser(
        user: AuthUser
    ): Flow<Resource<String>>
}