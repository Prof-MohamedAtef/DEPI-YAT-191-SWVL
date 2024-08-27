package mo.ed.ismailia.yat.kotlin.domain.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mo.ed.ismailia.yat.kotlin.data.dto.TripsEntity
import mo.ed.ismailia.yat.kotlin.domain.dao.TripsDao

@Database(entities = [TripsEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tripDao() : TripsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabaseInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "swvl-database-data"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}