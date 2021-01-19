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

public class LlamadasAdapter extends RecyclerView.Adapter<LlamadasAdapter.LlamadasViewHolder> {

    private Context Ctx;
    private List<Contactos> lstContactos;

    public LlamadasAdapter(Context ctx, List<Contactos> lstContactos) {
        Ctx = ctx;
        this.lstContactos = lstContactos;
    }

    @NonNull
    @Override
    public LlamadasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_llamadas, null);
        return new LlamadasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LlamadasAdapter.LlamadasViewHolder holder, int position) {
        Contactos contacto = lstContactos.get(position);
        holder.textViewName.setText(contacto.getNombre());
        holder.textViewInferior.setText("(2) Ayer 17:50");
        Glide.with(Ctx).load(contacto.getUrlPerfil()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lstContactos.size();
    }

    public class LlamadasViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewInferior;
        ImageView imageView;
        public LlamadasViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.txtName);
            textViewInferior= itemView.findViewById(R.id.txtInferior);
            imageView= itemView.findViewById(R.id.imgPerfil);
        }
    }
}
