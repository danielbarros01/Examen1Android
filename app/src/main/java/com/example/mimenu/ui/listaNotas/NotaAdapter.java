package com.example.mimenu.ui.listaNotas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mimenu.R;

import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder>{

    private Context context;
    private List<String> notas;
    private LayoutInflater inflater;

    public NotaAdapter(Context context, List<String> notas, LayoutInflater inflater) {
        this.context = context;
        this.notas = notas;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public NotaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //enterar al adapter que el item es el cardView item_nota.xml
        View root = inflater.inflate(R.layout.item_nota, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaAdapter.ViewHolder holder, int position) {
        holder.descripcion.setText(notas.get(position));
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descripcion;
        CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardViewId);

            descripcion = itemView.findViewById(R.id.tvDescripcion);
        }
    }
}
