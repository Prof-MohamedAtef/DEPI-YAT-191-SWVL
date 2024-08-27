package mo.ed.ismailia.yat.kotlin.network.retrofit

import mo.ed.ismailia.yat.kotlin.data.response.trips.TripsResponse
import mo.ed.ismailia.yat.kotlin.data.response.trips.TripsResponseItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("rahlat/rahlat/public/api/trips/")
    suspend fun getTrips() : Response<List<TripsResponseItem>>
}