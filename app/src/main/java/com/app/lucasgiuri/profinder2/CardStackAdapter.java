package com.app.lucasgiuri.profinder2;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.lucasgiuri.profinder2.Models.Profesor;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Profesor> profesores;

    public CardStackAdapter(Context context, List<Profesor> profesores) {
        this.inflater = LayoutInflater.from(context);
        this.profesores = profesores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.card_swipe, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Profesor profesor = profesores.get(position);
        holder.name.setText(profesor.getNombre());
        holder.description.setText(profesor.getNombre());
        holder.image.setImageURI("");
        holder.image.setImageURI(Uri.parse(profesor.getFoto()));
    }

    @Override
    public int getItemCount() {
        return profesores.size();
    }

    public void addProfesores(List<Profesor> profesores) {
        this.profesores.addAll(profesores);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        SimpleDraweeView image;

        ViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.name);
            this.description = view.findViewById(R.id.description);
            this.image = view.findViewById(R.id.cardImage);
        }
    }

}