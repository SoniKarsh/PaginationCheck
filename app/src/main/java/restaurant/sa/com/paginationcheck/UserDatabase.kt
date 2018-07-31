package restaurant.sa.com.paginationcheck

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [(Movie::class)], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun movieDao() : MovieDao

}