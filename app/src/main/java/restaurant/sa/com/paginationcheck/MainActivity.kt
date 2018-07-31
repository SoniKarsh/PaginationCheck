package restaurant.sa.com.paginationcheck

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout = LinearLayoutManager(this)
        mAdapter = RecyclerAdapter(tempList)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = layout
        recyclerView.adapter = mAdapter
        prepareMovieData()
        simpleSwipeRefreshLayout.setOnRefreshListener {
            Handler().postDelayed({
                simpleSwipeRefreshLayout.setRefreshing(false);
                for(i in startC..stop){
                    tempList.add(movieList[i])
                }
                recyclerView.adapter = mAdapter
                startC += 5
                stop += 5
            }, 3000)
        }
    }

    private fun prepareMovieData() {
        var movie = Movie("Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)

        movie = Movie("Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)

        movie = Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)

        movie = Movie("Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)

        movie = Movie("The Martian", "Science Fiction & Fantasy", "2015")
        movieList.add(movie)

        movie = Movie("Mission: Impossible Rogue Nation", "Action", "2015")
        movieList.add(movie)

        movie = Movie("Up", "Animation", "2009")
        movieList.add(movie)

        movie = Movie("Star Trek", "Science Fiction", "2009")
        movieList.add(movie)

        movie = Movie("The LEGO Movie", "Animation", "2014")
        movieList.add(movie)

        movie = Movie("Iron Man", "Action & Adventure", "2008")
        movieList.add(movie)

        movie = Movie("Aliens", "Science Fiction", "1986")
        movieList.add(movie)

        movie = Movie("Chicken Run", "Animation", "2000")
        movieList.add(movie)

        movie = Movie("Back to the Future", "Science Fiction", "1985")
        movieList.add(movie)

        movie = Movie("Raiders of the Lost Ark", "Action & Adventure", "1981")
        movieList.add(movie)

        movie = Movie("Goldfinger", "Action & Adventure", "1965")
        movieList.add(movie)

        movie = Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        movieList.add(movie)

//        mAdapter!!.notifyDataSetChanged()
    }

}
