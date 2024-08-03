package mo.ed.ismailia.yat.kotlin.feature.model

import java.io.Serializable

data class Trip(var tripID: String, var departureTime: String, var arrivalTime: String, var driverName: String, var pickupAddress: String, var destinationAddress: String) : Serializable