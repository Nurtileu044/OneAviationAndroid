package com.ablazim.oneaviationandroid.trips

import com.ablazim.oneaviationandroid.di.InjectionModule
import com.ablazim.oneaviationandroid.trips.ui.TripsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object TripsModule : InjectionModule {
    override fun create(): Module = module {

        viewModel { TripsViewModel(get()) }
    }
}