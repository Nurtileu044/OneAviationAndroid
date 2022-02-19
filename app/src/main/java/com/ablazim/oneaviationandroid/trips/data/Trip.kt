package com.ablazim.oneaviationandroid.trips.data

import java.io.Serializable

data class Trip(
    val fromLocation: String = "",
    val toLocation: String = "",
    val fromTime: String = "",
    val toTime: String = "",
    val ticketPrice: String = ""
) : Serializable