package com.daffa.minimisi.di

import com.daffa.minimisi.domain.usecase.AuthUseCase
import com.daffa.minimisi.domain.usecase.IAuthUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<IAuthUseCase> { AuthUseCase(get()) }
}