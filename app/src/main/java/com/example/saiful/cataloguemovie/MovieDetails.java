package com.example.saiful.cataloguemovie;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saiful.cataloguemovie.model.Movie;
import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_movie_details);

        TextView originalTitleTV = findViewById (R.id.titleTextView);
        TextView ratingTV = findViewById (R.id.ratingTextView);
        TextView releaseDateTV = findViewById (R.id.releaseDateTextView);
        TextView overviewTV = findViewById (R.id.overviewTextView);
        ImageView posterIV = findViewById (R.id.posterImageView);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        Movie movie = intent.getParcelableExtra("movie");


        originalTitleTV.setText(movie.getOriginalTitle());

        ratingTV.setText (movie.getVoterAverage() + " / 10");

        Picasso.with(this)
                .load(movie.getPosterPath())
                .fit()
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(posterIV);

        overviewTV.setText (movie.getOverview ());


        releaseDateTV.setText (movie.getReleaseDate());
    }


    private void closeOnError() {
        finish();
        Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
    }
}