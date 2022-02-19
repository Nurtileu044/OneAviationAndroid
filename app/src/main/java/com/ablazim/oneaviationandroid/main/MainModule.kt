package com.ablazim.oneaviationandroid.main

import com.ablazim.oneaviationandroid.di.InjectionModule
import com.ablazim.oneaviationandroid.main.ui.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object MainModule : InjectionModule {
    override fun create(): Module = module {
        viewModel { MainViewModel(get()) }
    }
}