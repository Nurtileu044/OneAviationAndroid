package com.ablazim.oneaviationandroid.splash

import com.ablazim.oneaviationandroid.BuildConfig
import com.ablazim.oneaviationandroid.base.BaseViewModelDependency
import com.ablazim.oneaviationandroid.base.ErrorHandler
import com.ablazim.oneaviationandroid.di.InjectionModule
import com.ablazim.oneaviationandroid.splash.ui.SplashViewModel
import com.ablazim.oneaviationandroid.utlis.DefaultLogger
import com.ablazim.oneaviationandroid.utlis.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object SplashModule : InjectionModule {
    override fun create(): Module = module {
        single<Logger> { DefaultLogger(BuildConfig.DEBUG) }
        single {
            val errorHandler = ErrorHandler(androidContext())
            BaseViewModelDependency(androidContext(), get(), errorHandler)
        }
        
        viewModel { SplashViewModel(get()) }
    }
}