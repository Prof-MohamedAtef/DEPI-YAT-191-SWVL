package mo.ed.ismailia.yat.kotlin.data.repository.trips

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mo.ed.ismailia.yat.kotlin.data.Result
import mo.ed.ismailia.yat.kotlin.data.exception.BaseException
import mo.ed.ismailia.yat.kotlin.data.exception.UnknownException
import mo.ed.ismailia.yat.kotlin.data.response.trips.TripsResponse
import mo.ed.ismailia.yat.kotlin.data.response.trips.TripsResponseItem
import mo.ed.ismailia.yat.kotlin.data.response.trips.mapTripResponseItemToTripEntity
import mo.ed.ismailia.yat.kotlin.domain.dao.TripsDao
import mo.ed.ismailia.yat.kotlin.network.NetworkResultWrapper
import mo.ed.ismailia.yat.kotlin.network.retrofit.ApiService
import mo.ed.ismailia.yat.kotlin.utils.Constants
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class TripsRepository(
    private val tripDao: TripsDao
) {
    /*
    implement retrofit call
    create apiService
     */
    private val apiService: ApiService
    init {
        val okHttpClient = OkHttpClient
            .Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.NetworkConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    /*
    use getTrips function from ApiService
     */
    suspend fun getTrips(isConnected: Boolean): Result<*>{
        return if (isConnected){
            try {
                val response = apiService.getTrips()
                if (response.isSuccessful) {
                    response.body()?.let { tripResponse ->
                        if (tripResponse.isNotEmpty()) {
                            tripDao?.let {
                                it.deleteAllTrips()
                                saveTripsLocally(tripResponse)
                            }
                        }
                    }

                    // Fetch trips from the local database after saving
                    val trips = tripDao?.getAllTrips()
                    trips?.let {
                        Result.Success(it)
                    } ?: Result.Error("No trips found in the database")

                } else {
                    // Return error if the response is not successful
                    Result.Error("Error: ${response.code()}")
                }
            }catch (e: Exception){
                Result.Failure(e as? BaseException)
            }
        }else{
            val trips = tripDao?.getAllTrips()
            trips?.let {
                Result.Success(it)
            } ?: Result.Error("No trips found in the database")
        }
//        if (isConnected){
//            apiService.getTrips().enqueue(object: retrofit2.Callback<List<TripsResponseItem>>{
//                override fun onResponse(
//                    call: Call<List<TripsResponseItem>>,
//                    response: Response<List<TripsResponseItem>>
//                ) {
//                    GlobalScope.launch(Dispatchers.IO) {
//                        if (response.isSuccessful) {
//                            tripDao?.let {
//                                response.body()?.let { tripResponse->
//                                    if (tripResponse.size > 0){
//                                        it.deleteAllTrips()
//                                        saveTripsLocally(tripResponse)
//                                    }
//                                    val trips = it.getAllTrips()
//                                    Result.Success(trips)
//                                } ?: Result.Error("response success but is null")
//                            }
//                        }else{
//                            Result.Error("Error: ${response.code()}")
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<List<TripsResponseItem>>, t: Throwable) {
//                    Result.Failure(t as? BaseException)
//                }
//            })
//        }else{
//            return Result.Success(tripDao?.getAllTrips())
//        }
//        return Result.Loading()
    }

    suspend fun saveTripsLocally(tripsResponse: List<TripsResponseItem>){
        val tripEntity = tripsResponse.map { mapTripResponseItemToTripEntity(it) }
        tripEntity.forEach {
            tripDao.insertTrip(it)
        }
    }
}