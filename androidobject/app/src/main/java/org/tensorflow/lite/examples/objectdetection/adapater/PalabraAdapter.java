package org.tensorflow.lite.examples.objectdetection.adapater;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.tensorflow.lite.examples.objectdetection.R;
import org.tensorflow.lite.examples.objectdetection.login.Imagenes;
import org.tensorflow.lite.examples.objectdetection.login.Resultado;

import java.util.List;


public class PalabraAdapter extends RecyclerView.Adapter<PalabraAdapter.ViewHolder> {

    private Resultado resultado;
    private Context context;

    public PalabraAdapter(Resultado resultado, Context context) {
        this.resultado = resultado;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_images, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(resultado.getNombre());
        holder.desc.setText(resultado.getDescripcion());

        // Convert the list of images to a string
        List<Imagenes> imagenes = resultado.getImagenes();
        if (imagenes != null && !imagenes.isEmpty()) {
            holder.imageAdapter.setImages(imagenes);

            StringBuilder urls = new StringBuilder();
            for (Imagenes imagen : imagenes) {
                urls.append(imagen.getUrl()).append("\n");
            }
            //holder.imageUrls.setText(urls.toString());
        } else {
            holder.desc.setText("No hay imágenes disponibles");
            //holder.imageUrls.setText("No images available");
        }
    }


    @Override
    public int getItemCount() {
        return 1; // Only one item
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView desc;

        //private TextView imageUrls;
        private RecyclerView recyclerViewImages;
        private ImageAdapter imageAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            desc = itemView.findViewById(R.id.desc);
            //imageUrls = itemView.findViewById(R.id.imageUrls);
            recyclerViewImages = itemView.findViewById(R.id.recyclerViewImages);
            recyclerViewImages.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            imageAdapter = new ImageAdapter(context);
            recyclerViewImages.setAdapter(imageAdapter);
        }
    }
}