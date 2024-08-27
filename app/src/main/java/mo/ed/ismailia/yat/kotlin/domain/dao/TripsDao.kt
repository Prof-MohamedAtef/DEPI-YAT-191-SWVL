package mo.ed.ismailia.yat.kotlin.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mo.ed.ismailia.yat.kotlin.data.dto.TripsEntity

@Dao
interface TripsDao {
//    CRUDS
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrip(tripEntity: TripsEntity)

    @Query("DELETE FROM tbl_trips")
    suspend fun deleteAllTrips()

    @Query("SELECT * FROM tbl_trips")
    suspend fun getAllTrips() : List<TripsEntity?>?

    @Query("SELECT * FROM tbl_trips WHERE tripId =:tripId LIMIT 1")
    suspend fun getTripById(tripId: Int) : TripsEntity?

    suspend fun insertOrUpdate(tripEntity: TripsEntity, local: String){
        val localeData = tripEntity.copy(locale = if (local.isNotEmpty()) local else "en")
        insertTrip(localeData)
    }
}