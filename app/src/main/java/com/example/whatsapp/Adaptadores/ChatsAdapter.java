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


public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ContactoViewHolder> {

    private Context Ctx;
    private List<Contactos> lstContactos;

    public ChatsAdapter(Context ctx, List<Contactos> lstContactos) {
        Ctx = ctx;
        this.lstContactos = lstContactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_contactos, null);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contactos contacto = lstContactos.get(position);
        holder.textViewName.setText(contacto.getNombre());
        holder.textViewInferior.setText("Hola, ¿Cómo estas pasando?");
        holder.textViewHora.setText("14:25");

        Glide.with(Ctx).load(contacto.getUrlPerfil()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lstContactos.size();
    }


    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewInferior, textViewHora;
        ImageView imageView;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.txtName);
            textViewInferior= itemView.findViewById(R.id.txtInferior);
            textViewHora= itemView.findViewById(R.id.txtHora);
            imageView= itemView.findViewById(R.id.imgPerfil);
        }
    }
}
