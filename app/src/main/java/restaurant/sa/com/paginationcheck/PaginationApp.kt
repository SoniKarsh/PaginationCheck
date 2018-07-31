package restaurant.sa.com.paginationcheck

import android.app.Application
import android.arch.persistence.room.Room

class PaginationApp: Application() {

    companion object {
        var database: UserDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        PaginationApp.database = Room.databaseBuilder(this, UserDatabase::class.java, "Movie-db").allowMainThreadQueries().build()
    }
}
