package com.ablazim.oneaviationandroid.main.ui

import com.ablazim.oneaviationandroid.R
import com.ablazim.oneaviationandroid.base.Action
import com.ablazim.oneaviationandroid.base.BaseViewModel
import com.ablazim.oneaviationandroid.base.BaseViewModelDependency
import com.ablazim.oneaviationandroid.base.EmptyState

class MainViewModel(
    baseViewModelDependency: BaseViewModelDependency
) : BaseViewModel<EmptyState, MainAction>(baseViewModelDependency, EmptyState) {
    
    private var currentItemId = R.id.trips
    
    init {
        invalidateNavigationItems()
    }
    
    fun onNavigationItemClicked(itemId: Int) {
        currentItemId = itemId
        invalidateNavigationItems()
    }
    
    private fun invalidateNavigationItems() {
        when (currentItemId) {
            R.id.trips -> sendAction(MainAction.ShowTripsScreen)
            R.id.myTrips -> sendAction(MainAction.ShowMyTripsScreen)
        }
    }
}

sealed class MainAction : Action {
    object ShowTripsScreen : MainAction()
    object ShowMyTripsScreen : MainAction()
}