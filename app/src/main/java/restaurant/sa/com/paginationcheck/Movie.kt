package restaurant.sa.com.paginationcheck

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Movie")
data class Movie(@PrimaryKey(autoGenerate = true) var _id: Long?,
                     @ColumnInfo(name = "title") var title: String,
                     @ColumnInfo(name = "genre") var genre: String,
                     @ColumnInfo(name = "year") var year: String
){
    constructor():this(null,"", "", "")
}