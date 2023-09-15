package com.daffa.minimisi.di

import com.daffa.minimisi.presentation.login.LoginViewModel
import com.daffa.minimisi.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RegisterViewModel() }
    viewModel { LoginViewModel() }
}