package com.ablazim.oneaviationandroid.trips.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ablazim.oneaviationandroid.R
import com.ablazim.oneaviationandroid.databinding.FragmentTripsBinding
import org.koin.android.viewmodel.ext.android.viewModel

class TripsFragment : Fragment(R.layout.fragment_trips) {
    
    private lateinit var binding: FragmentTripsBinding
    private val viewModel: TripsViewModel by viewModel()
    
    private val adapter: TripsAdapter by lazy {
        TripsAdapter(
            { }
        )
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTripsBinding.bind(view)
        
        with(binding) {
            viewModel.trips.observe(viewLifecycleOwner) { list ->
                adapter.setItems(list)
            }
            
        }
        
    }
}