package mo.ed.ismailia.yat.kotlin.data.repository.trips

import mo.ed.ismailia.yat.kotlin.data.response.trips.TripsResponse
import mo.ed.ismailia.yat.kotlin.network.NetworkResultWrapper
import mo.ed.ismailia.yat.kotlin.network.retrofit.ApiService
import mo.ed.ismailia.yat.kotlin.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class TripsRepository {
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
    suspend fun getTrips(callback: (NetworkResultWrapper<TripsResponse?>) -> Unit){
        callback(NetworkResultWrapper.Loading) /// --> Start Loading
        apiService.getTrips().enqueue(object: retrofit2.Callback<TripsResponse?>{
            override fun onResponse(
                call: Call<TripsResponse?>,
                response: Response<TripsResponse?>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { tripResponse->
                        callback(NetworkResultWrapper.Success(tripResponse))
                    } ?: callback(NetworkResultWrapper.Error("response success but is null"))
                }else{
                    callback(NetworkResultWrapper.Error("Error with code: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<TripsResponse?>, t: Throwable) {
                callback(NetworkResultWrapper.Failure)
            }
        })
    }
}