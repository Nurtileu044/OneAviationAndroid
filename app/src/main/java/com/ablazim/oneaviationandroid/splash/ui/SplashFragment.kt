package com.ablazim.oneaviationandroid.splash.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ablazim.oneaviationandroid.R
import com.ablazim.oneaviationandroid.extensions.replaceFragment
import com.ablazim.oneaviationandroid.main.ui.MainFragment
import org.koin.android.viewmodel.ext.android.viewModel

class SplashFragment : Fragment(R.layout.fragment_splash) {
    
    private val viewModel: SplashViewModel by viewModel()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.actions.observe(viewLifecycleOwner) { action ->
            when (action) {
                is SplashAction.ShowMainScreen -> replaceFragment(MainFragment())
            }
        }
    }
}