package mo.ed.ismailia.yat.kotlin.data.response.trips

data class TripsResponseItem(
    val arrival: String,
    val availability: String,
    val departure: String,
    val from: String,
    val fromLat: Double,
    val fromLong: Double,
    val price: String,
    val time_from: String,
    val time_to: String,
    val to: String,
    val toLat: Double,
    val toLong: Double
)