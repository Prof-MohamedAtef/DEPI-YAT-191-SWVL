package mo.ed.ismailia.yat.kotlin.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "tbl_trips", indices = [Index(value = ["tripId"], unique = true)])
data class TripsEntity(
    @PrimaryKey
    @ColumnInfo(name = "tripId")
    val tripId: Int? = null,
    @ColumnInfo(name = "arrival")
    val arrival: String = "",
    @ColumnInfo(name = "availability")
    val availability: String = "",
    @ColumnInfo(name = "departure")
    val departure: String = "",
    @ColumnInfo(name = "from")
    val from: String = "",
    @ColumnInfo(name = "fromLat")
    val fromLat: Double = 0.0,
    @ColumnInfo(name = "fromLong")
    val fromLong: Double = 0.0,
    @ColumnInfo(name = "price")
    val price: String = "",
    @ColumnInfo(name = "time_from")
    val time_from: String = "",
    @ColumnInfo(name = "time_to")
    val time_to: String = "",
    @ColumnInfo(name = "to")
    val to: String = "",
    @ColumnInfo(name = "toLat")
    val toLat: Double = 0.0,
    @ColumnInfo(name = "toLong")
    val toLong: Double = 0.0,
    @ColumnInfo(name = "locale")
    var locale: String = "",
)
