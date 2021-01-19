package com.example.whatsapp.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.whatsapp.Modelos.Contactos;
import com.example.whatsapp.R;

import java.util.List;

public class EstadosAdapter extends RecyclerView.Adapter<EstadosAdapter.EstadosViewHolder> {

    private Context Ctx;
    private List<Contactos> lstContactos;

    public EstadosAdapter(Context ctx, List<Contactos> lstContactos) {
        Ctx = ctx;
        this.lstContactos = lstContactos;
    }

    @NonNull
    @Override
    public EstadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_estados, null);
        return new EstadosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadosAdapter.EstadosViewHolder holder, int position) {
        Contactos contacto = lstContactos.get(position);
        holder.textViewName.setText(contacto.getNombre());
        holder.textViewInferior.setText("Hoy 10:20");
        Glide.with(Ctx).load(contacto.getUrlPerfil()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lstContactos.size();
    }

    public class EstadosViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewInferior;
        ImageView imageView;
        public EstadosViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.txtName);
            textViewInferior= itemView.findViewById(R.id.txtInferior);
            imageView= itemView.findViewById(R.id.imgPerfil);
        }
    }
}
