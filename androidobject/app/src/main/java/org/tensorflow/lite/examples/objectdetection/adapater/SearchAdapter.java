package org.tensorflow.lite.examples.objectdetection.adapater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.objectdetection.login.Palabra;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<Palabra> itemList;
    private List<Palabra> itemListFull;
    private OnItemClickListener listener;

    public SearchAdapter(List<Palabra> itemList, OnItemClickListener listener) {
        this.itemList = new ArrayList<>(itemList);
        this.itemListFull = new ArrayList<>(itemList);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Palabra palabra = itemList.get(position);
        holder.textView.setText(palabra.getNombre());
        holder.textView.setTextColor(ContextCompat.getColor(holder.textView.getContext(), android.R.color.black));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(itemList.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Palabra palabra);
    }

    public void filter(String text) {
        itemList.clear();
        if (text.isEmpty()) {
            itemList.addAll(itemListFull);
        } else {
            text = text.toLowerCase();
            for (Palabra palabra : itemListFull) {
                if (palabra.getNombre().toLowerCase().contains(text)) {
                    itemList.add(palabra);
                }
            }
        }
        notifyDataSetChanged();
    }
}
