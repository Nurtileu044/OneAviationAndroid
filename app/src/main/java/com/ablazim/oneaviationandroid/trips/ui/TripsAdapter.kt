package com.ablazim.oneaviationandroid.trips.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ablazim.oneaviationandroid.base.BaseAdapter
import com.ablazim.oneaviationandroid.base.BaseViewHolder
import com.ablazim.oneaviationandroid.databinding.ItemSimilarFlightsBinding
import com.ablazim.oneaviationandroid.trips.data.Trip

class TripsAdapter(
    private val onDetailsClicked: () -> Unit
) : BaseAdapter<Trip>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Trip> =
        TripsViewHolder(
            ItemSimilarFlightsBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onDetailsClicked
        )
    
    private class TripsViewHolder(
        private val viewBinding: ItemSimilarFlightsBinding,
        private val onDetailsClicked: () -> Unit
    ) : BaseViewHolder<Trip>(viewBinding.root) {
        
        override fun onBind(item: Trip) {
            super.onBind(item)
            with(viewBinding) {
                fromLocationTextView.text = item.fromLocation
                toLocationTextView.text = item.toLocation
                toFlightTimeTextView.text = item.toTime
                fromFlightTimeTextView.text = item.fromTime
                costTextView.text = item.ticketPrice
                detailsTextView.setOnClickListener { onDetailsClicked.invoke() }
            }
        }
    }
}