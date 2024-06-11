package org.tensorflow.lite.examples.objectdetection.adapater;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.tensorflow.lite.examples.objectdetection.login.Imagenes;
import org.tensorflow.lite.examples.objectdetection.R;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<Imagenes> imagenes = new ArrayList<>();
    private Context context;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    public void setImages(List<Imagenes> imagenes) {
        this.imagenes = imagenes;
        Log.d("ImageAdapter", "Imagnes"+ imagenes.size());
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Imagenes imagen = imagenes.get(position);
        Glide.with(context).load(imagen.getUrl()).into(holder.imageView);
        Log.d("ImageAdapter", "Image URL: " + imagen.getUrl());
    }


    @Override
    public int getItemCount() {
        int itemCount = imagenes.size();
        Log.d("ImageAdapter", "Número de imágenes: " + itemCount);
        return itemCount;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
