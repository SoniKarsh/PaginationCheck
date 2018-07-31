package restaurant.sa.com.paginationcheck

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getAll(): List<Movie>

    @Insert
    fun insertData(movieData: Movie)

    @Query("DELETE from Movie")
    fun deleteAll()

    @Query("SELECT * FROM Movie LIMIT :limit OFFSET :offset")
    fun loadAllUsersByPage(limit: Int, offset: Int): Movie

}