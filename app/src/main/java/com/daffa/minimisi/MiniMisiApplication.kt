package com.daffa.minimisi

import android.app.Application
import com.daffa.minimisi.di.firebaseModule
import com.daffa.minimisi.di.repositoryModule
import com.daffa.minimisi.di.useCaseModule
import com.daffa.minimisi.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MiniMisiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            val logger = if (BuildConfig.DEBUG) Level.INFO else Level.NONE
            androidLogger(logger)
            androidContext(this@MiniMisiApplication)
            modules(
                listOf(
                    firebaseModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}