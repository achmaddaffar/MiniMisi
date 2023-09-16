package com.daffa.minimisi.domain.usecase

import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.data.model.AuthUser
import com.daffa.minimisi.domain.repository.IAuthRepository
import kotlinx.coroutines.flow.Flow

class AuthUseCase(
    private val repository: IAuthRepository,
) : IAuthUseCase {
    override fun login(email: String, password: String): Flow<Resource<String>> =
        repository.loginUser(
            AuthUser(
                email,
                password
            )
        )

    override fun register(email: String, password: String): Flow<Resource<String>> =
        repository.register(
            AuthUser(
                email,
                password
            )
        )
}