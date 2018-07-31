package restaurant.sa.com.paginationcheck

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM User")
    fun getAll(): List<Movie>

    @Insert
    fun insertData(userModel: Movie)

    @Query("DELETE from User")
    fun deleteAll()

}