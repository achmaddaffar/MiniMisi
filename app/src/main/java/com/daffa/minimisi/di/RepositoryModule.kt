package com.daffa.minimisi.di

import com.daffa.minimisi.data.repository.AuthRepository
import com.daffa.minimisi.domain.repository.IAuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IAuthRepository> { AuthRepository(get()) }
}