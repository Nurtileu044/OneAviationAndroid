package com.ablazim.oneaviationandroid.trips.ui

import androidx.lifecycle.LiveData
import com.ablazim.oneaviationandroid.base.Action
import com.ablazim.oneaviationandroid.base.BaseViewModel
import com.ablazim.oneaviationandroid.base.BaseViewModelDependency
import com.ablazim.oneaviationandroid.base.SingleLiveEvent
import com.ablazim.oneaviationandroid.base.ViewState
import com.ablazim.oneaviationandroid.trips.data.Trip

class TripsViewModel(
    baseViewModelDependency: BaseViewModelDependency
) : BaseViewModel<TripsViewState, TripsAction>(baseViewModelDependency, TripsViewState()) {

    private val _trips = SingleLiveEvent<List<Trip>>()
    val trips: LiveData<List<Trip>> = _trips
    
    init {
        _trips.postValue(listOf(
            Trip("IST", "KZT", "11:50pm", "18.35am", "520$"),
            Trip("NQZ", "ATA", "13:30am", "15.20am", "140$"),
            Trip("KZO", "TSE", "07:10am", "09.05am", "220$"),
            Trip("ANT", "GRE", "12:20pm", "16.30am", "890$"),
            Trip("GRE", "MDA", "20:45pm", "22.45am", "730$"),
        ))
    }

}

data class TripsViewState(
    val isLoading: Boolean = false
) : ViewState

sealed class TripsAction : Action {

}