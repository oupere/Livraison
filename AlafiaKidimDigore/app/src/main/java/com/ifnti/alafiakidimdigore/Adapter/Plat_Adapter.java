package com.ifnti.alafiakidimdigore.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ifnti.alafiakidimdigore.DetailsActivity;
import com.ifnti.alafiakidimdigore.Modele.Plat;
import com.ifnti.alafiakidimdigore.R;
import java.util.ArrayList;

public class Plat_Adapter extends RecyclerView.Adapter<Plat_Adapter.ViewHolder> {
        ArrayList<Plat> foodDomains;

    public Plat_Adapter(ArrayList<Plat> foodDomains) {
        this.foodDomains = foodDomains;
        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.affichage_plats, parent, false);

        return new ViewHolder(inflate);
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.libelle.setText(foodDomains.get(position).getLibelle());
        holder.prix_unitaire.setText(String.valueOf(foodDomains.get(position).getPrix_unitaire()));


        int drawableReourceId = holder.itemView.getContext().getResources()
        .getIdentifier(foodDomains.get(position).getImage_plats(), "drawable",
        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
        .load(drawableReourceId)
        .into(holder.image_plats);

        holder.addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
            intent.putExtra("object", foodDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
        }

    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView libelle, prix_unitaire;
        ImageView image_plats;
        ImageView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            libelle = itemView.findViewById(R.id.title);
            image_plats = itemView.findViewById(R.id.pic);
            prix_unitaire = itemView.findViewById(R.id.fee);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}