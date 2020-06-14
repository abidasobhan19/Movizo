package com.example.movizo.Horizontal_Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movizo.PopularMovie;
import com.example.movizo.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Horizontal_Adapter extends RecyclerView.Adapter<Horizontal_Adapter.horizontalholder>{

    private Context context;
    private LayoutInflater inflater;
    private List<PopularMovie> popularMovieList;

    public Horizontal_Adapter(Context context){
        this.context = context;
        this.inflater= LayoutInflater.from(context);
        this.popularMovieList= new ArrayList<>();
    }
    @NonNull
    @Override
    public horizontalholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.horizontal_view,parent,false);
        return new horizontalholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull horizontalholder holder, int position) {

        PopularMovie popularMovie = popularMovieList.get(position);
        holder.bind(popularMovie);
    }

    @Override
    public int getItemCount() {
        return popularMovieList.size();
    }

    public List<PopularMovie> getPopularMovieList(){
        return this.popularMovieList;
    }

    public void addpropularMovies(PopularMovie popularMovie){
        this.getPopularMovieList().add(popularMovie);
        int position = this.getPopularMovieList().indexOf(popularMovie);
        this.notifyItemInserted(position);

    }

    class horizontalholder extends RecyclerView.ViewHolder{

        ImageView movie_img;
        TextView movie_name;


        public horizontalholder(@NonNull View itemView) {
            super(itemView);
            movie_img=itemView.findViewById(R.id.movie_img);
            movie_name=itemView.findViewById(R.id.movie_name);
        }

        public void bind(PopularMovie popularMovie){
            FirebaseDatabase.getInstance().getReference().child("Movies");
            popularMovie.setImagelink(popularMovie.getImagelink());


            movie_name.setText(popularMovie.getName());

            if(!popularMovie.getImagelink().equals("")){
                Picasso.get()
                        .load(popularMovie.getImagelink())
                        .into(movie_img);
            }
        }
    }
}
