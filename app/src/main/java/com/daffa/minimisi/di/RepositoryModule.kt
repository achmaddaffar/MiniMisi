package com.daffa.minimisi.di

import com.daffa.minimisi.data.repository.AuthRepository
import com.daffa.minimisi.data.repository.RealtimeDbRepository
import com.daffa.minimisi.domain.repository.IAuthRepository
import com.daffa.minimisi.domain.repository.IRealtimeDbRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IAuthRepository> { AuthRepository(get()) }
    single<IRealtimeDbRepository> { RealtimeDbRepository(get()) }
}