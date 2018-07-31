package restaurant.sa.com.paginationcheck

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_view.view.*

class RecyclerAdapter(var moviesList: ArrayList<Movie>): RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false))
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val movie = moviesList.get(position)
        holder.title.setText(movie.title)
        holder.genre.setText(movie.genre)
        holder.year.setText(movie.year)
    }

    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var title = view.title
        var genre = view.genre
        var year = view.year
    }

}