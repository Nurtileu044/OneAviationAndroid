package com.ablazim.oneaviationandroid.main.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ablazim.oneaviationandroid.R
import com.ablazim.oneaviationandroid.databinding.FragmentMainBinding
import com.ablazim.oneaviationandroid.extensions.findFragmentByTag
import com.ablazim.oneaviationandroid.extensions.replaceChildFragment
import com.ablazim.oneaviationandroid.trips.ui.TripsFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {
    
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModel()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            viewModel.onNavigationItemClicked(menuItem.itemId)
            true
        }
        
        viewModel.actions.observe(viewLifecycleOwner) { action ->
            when (action) {
                is MainAction.ShowMyTripsScreen -> showMyTripsScreen()
                is MainAction.ShowTripsScreen -> showTripsScreen()
            }
        }
    }
    
    private fun showMyTripsScreen() {
    
    }
    
    private fun showTripsScreen() {
        val fragment = findFragmentByTag(TripsFragment::class.java.name) ?: TripsFragment()
        replaceChildFragment(fragment)
    }
}