package com.daffa.minimisi.di

import com.daffa.minimisi.domain.usecase.AuthUseCase
import com.daffa.minimisi.domain.usecase.GigUseCase
import com.daffa.minimisi.domain.usecase.IAuthUseCase
import com.daffa.minimisi.domain.usecase.IGigUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<IAuthUseCase> { AuthUseCase(get(), get()) }
    factory<IGigUseCase> { GigUseCase(get()) }
}