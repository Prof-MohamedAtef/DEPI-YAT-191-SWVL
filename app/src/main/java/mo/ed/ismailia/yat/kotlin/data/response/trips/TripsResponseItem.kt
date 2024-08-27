package mo.ed.ismailia.yat.kotlin.data.response.trips

import mo.ed.ismailia.yat.kotlin.data.dto.TripsEntity

data class TripsResponseItem(
    val arrival: String = "",
    val availability: String = "",
    val departure: String = "",
    val from: String = "",
    val fromLat: Double = 0.0,
    val fromLong: Double = 0.0,
    val price: String = "",
    val time_from: String = "",
    val time_to: String = "",
    val to: String = "",
    val toLat: Double = 0.0,
    val toLong: Double = 0.0,
)


fun mapTripResponseItemToTripEntity(tripResponse: TripsResponseItem) : TripsEntity{
    return TripsEntity(
        arrival = tripResponse.arrival,
        availability = tripResponse.availability,
        departure = tripResponse.departure,
        from = tripResponse.from,
        fromLat = tripResponse.fromLat,
        fromLong = tripResponse.fromLong,
        price = tripResponse.price,
        time_from = tripResponse.time_from,
        time_to = tripResponse.time_to,
        to = tripResponse.to,
        toLat = tripResponse.toLat,
        toLong = tripResponse.toLong,
    )
}