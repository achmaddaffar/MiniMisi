package com.daffa.minimisi.domain.usecase

import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.data.model.AuthUser
import com.daffa.minimisi.domain.model.User
import com.daffa.minimisi.domain.repository.IAuthRepository
import com.daffa.minimisi.domain.repository.IRealtimeDbRepository
import kotlinx.coroutines.flow.Flow

class AuthUseCase(
    private val authRepository: IAuthRepository,
    private val dbRepository: IRealtimeDbRepository
) : IAuthUseCase {
    override fun login(email: String, password: String): Flow<Resource<String>> =
        authRepository.loginUser(
            AuthUser(
                email,
                password
            )
        )

    override fun register(email: String, password: String): Flow<Resource<String>> =
        authRepository.register(
            AuthUser(
                email,
                password
            )
        )

    override fun addUserToDb(user: User): Flow<Resource<String>> = dbRepository.addUser(user)

    override fun readUser(email: String): Flow<Resource<User>> = dbRepository.readUser(email)
}