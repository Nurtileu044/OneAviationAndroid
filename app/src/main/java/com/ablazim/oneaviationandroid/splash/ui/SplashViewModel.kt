package com.ablazim.oneaviationandroid.splash.ui

import com.ablazim.oneaviationandroid.base.Action
import com.ablazim.oneaviationandroid.base.BaseViewModel
import com.ablazim.oneaviationandroid.base.BaseViewModelDependency
import com.ablazim.oneaviationandroid.base.EmptyState

class SplashViewModel(
    baseViewModelDependency: BaseViewModelDependency
) : BaseViewModel<EmptyState, SplashAction>(baseViewModelDependency, EmptyState) {

    init {
        showMainScreen()
    }

    private fun showMainScreen() {
        sendAction(SplashAction.ShowMainScreen)
    }

}

sealed class SplashAction : Action {
    object ShowMainScreen : SplashAction()
}