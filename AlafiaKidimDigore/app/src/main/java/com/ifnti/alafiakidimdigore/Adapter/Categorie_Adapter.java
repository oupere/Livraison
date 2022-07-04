package com.ifnti.alafiakidimdigore.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ifnti.alafiakidimdigore.Modele.Categorie;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import com.ifnti.alafiakidimdigore.R;

public class Categorie_Adapter extends RecyclerView.Adapter<Categorie_Adapter.ViewHolder>{
    ArrayList<Categorie> categoryDomains;

    public Categorie_Adapter(ArrayList<Categorie> categoryDomains){
        super();
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.affichage_category, parent, false);
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.libelle.setText(categoryDomains.get(position).getLibelle());
        String picUrl="";
        switch (position) {
            case 0: {
                picUrl = "motou2";
                break;
            }
            case 1: {
                picUrl = "foufou4";
                break;
            }
            case 2: {
                picUrl = "salade2";
                break;
            }
            case 3: {
                picUrl = "spaghetti1";
                break;
            }
            case 4: {
                picUrl = "mafe";
                break;
            }
            case 5: {
                picUrl = "pizza3";
                break;
            }
            case 6: {
                picUrl = "burger";
                break;
            }
            case 7: {
                picUrl = "cat_1";
                break;
            }
            case 8: {
                picUrl = "rice";
                break;
            }
            case 9: {
                picUrl = "login_background2";
                break;
            }
            case 10: {
                picUrl = "cat_4";
                break;
            }
            case 11: {
                picUrl = "cat_5";
                break;
            }
        }

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(picUrl, "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.image_plats);
    }

    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView libelle;
        ImageView image_plats;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            libelle = itemView.findViewById(R.id.categoryName);
            image_plats = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

