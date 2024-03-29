package com.example.saiful.cataloguemovie;



import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import android.view.ViewGroup;

import com.example.saiful.cataloguemovie.model.Movie;
import com.squareup.picasso.*;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private final Movie[] mMovies;
    private final Context mContext;
    View.OnClickListener listener;

    public ImageAdapter(Context mContext, Movie[] mMovies) {
        this.mMovies = mMovies;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;

        public ViewHolder(ImageView v) {
            super(v);
            mImageView = v;
        }
    }
    @NonNull
    @Override
     public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create a new view
        ImageView v = (ImageView) LayoutInflater.from(parent.getContext ())
                .inflate (R.layout.image_thumb_view, parent, false);

        ViewHolder vh = new ViewHolder (v);
        return vh;
    }

    @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.with(mContext)
                .load(mMovies[position].getPosterPath())
                .fit()
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .into((ImageView) holder.mImageView.findViewById (R.id.image_view));

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, MovieDetails.class);
            intent.putExtra("movie", mMovies[position]);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (mMovies == null || mMovies.length == 0) {
            return -1;
        }

        return mMovies.length;
    }
}
