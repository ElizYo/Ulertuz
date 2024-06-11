package org.tensorflow.lite.examples.objectdetection.adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.tensorflow.lite.examples.objectdetection.R;
import org.tensorflow.lite.examples.objectdetection.login.Result;

import java.util.List;

public class PalabrasAdapater extends RecyclerView.Adapter<PalabrasAdapater.ViewHolder> {

    private List<Result> resultados;
    private Context context;
    private OnItemClickListener listener;

    public PalabrasAdapater(List<Result> resultados, Context context, OnItemClickListener listener) {
        this.resultados = resultados;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        return new ViewHolder(view);
    }

    public interface OnItemClickListener {
        void onItemClick(String itemId);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result resultado = resultados.get(position);
        String nombre = resultado.getNombre();
        holder.tv_titulo.setText(nombre);

        // Correctly load the first image from the list of images if available
        if (resultado.getImagenes() != null && !resultado.getImagenes().isEmpty()) {
            Glide.with(context)
                    .load(resultado.getImagenes().get(0).getUrl()) // Access the first image
                    .into(holder.iv_portada);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView iv_portada;
        private TextView tv_titulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_portada = itemView.findViewById(R.id.iv_portada);
            tv_titulo = itemView.findViewById(R.id.tv_titulo);

            // Set click listener
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Pass the clicked item's ID to the listener
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(String.valueOf(resultados.get(position).getId()));
            }
        }
    }
}


