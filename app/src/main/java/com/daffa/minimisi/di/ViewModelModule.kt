package com.daffa.minimisi.di

import com.daffa.minimisi.presentation.gigDetail.GigDetailViewModel
import com.daffa.minimisi.presentation.home.HomeViewModel
import com.daffa.minimisi.presentation.login.LoginViewModel
import com.daffa.minimisi.presentation.profile.ProfileViewModel
import com.daffa.minimisi.presentation.register.RegisterViewModel
import com.daffa.minimisi.presentation.search.SearchViewModel
import com.daffa.minimisi.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { SearchViewModel() }
    viewModel { GigDetailViewModel(get()) }
}