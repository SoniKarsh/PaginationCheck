package restaurant.sa.com.paginationcheck

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DefaultItemAnimator
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val movieList = ArrayList<Movie>()
    private var mAdapter: RecyclerAdapter? = null
    private var tempList = ArrayList<Movie>()
    var startC = 0
    var stop = 5
    var c = 0
    private val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout = LinearLayoutManager(this)
        mAdapter = RecyclerAdapter(tempList)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = layout
        recyclerView.adapter = mAdapter
        prepareMovieData()
        for(i in movieList){
            PaginationApp.database!!.movieDao().insertData(i)
        }
//        Log.d(TAG, "DB Call: ${PaginationApp.database!!.movieDao().getAll()}");
        simpleSwipeRefreshLayout.setOnRefreshListener {
            Handler().postDelayed({
                simpleSwipeRefreshLayout.setRefreshing(false);
//                if(c<4){
//                    tempList = PaginationApp.database!!
//                            .movieDao().loadAllUsersByPage(startC, stop) as ArrayList<Movie>
//                    Log.d(TAG, "$tempList");
//                    c++
//                }
                for(i in startC..stop){
                    Log.d(TAG, "$startC $stop");
                    tempList.add(PaginationApp.database!!
                            .movieDao().loadAllUsersByPage(1, ++startC))
//                    tempList.add(movieList[i])
                }
                recyclerView.adapter = mAdapter
                mAdapter!!.notifyDataSetChanged()
                Log.d(TAG, "$mAdapter: ")
                startC += 1
                stop += 5
            }, 3000)
        }
    }

    private fun prepareMovieData() {
        var movie = Movie(null, "Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)

        movie = Movie(null, "Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)

        movie = Movie(null, "Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)

        movie = Movie(null, "Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)

        movie = Movie(null, "The Martian", "Science Fiction & Fantasy", "2015")
        movieList.add(movie)

        movie = Movie(null, "Mission: Impossible Rogue Nation", "Action", "2015")
        movieList.add(movie)

        movie = Movie(null, "Up", "Animation", "2009")
        movieList.add(movie)

        movie = Movie(null, "Star Trek", "Science Fiction", "2009")
        movieList.add(movie)

        movie = Movie(null, "The LEGO Movie", "Animation", "2014")
        movieList.add(movie)

        movie = Movie(null, "Iron Man", "Action & Adventure", "2008")
        movieList.add(movie)

        movie = Movie(null, "Aliens", "Science Fiction", "1986")
        movieList.add(movie)

        movie = Movie(null, "Chicken Run", "Animation", "2000")
        movieList.add(movie)

        movie = Movie(null, "Back to the Future", "Science Fiction", "1985")
        movieList.add(movie)

        movie = Movie(null, "Raiders of the Lost Ark", "Action & Adventure", "1981")
        movieList.add(movie)

        movie = Movie(null, "Goldfinger", "Action & Adventure", "1965")
        movieList.add(movie)

        movie = Movie(null, "Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        movieList.add(movie)

//        mAdapter!!.notifyDataSetChanged()
    }

}
