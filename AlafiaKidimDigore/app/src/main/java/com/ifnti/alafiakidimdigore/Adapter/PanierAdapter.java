package com.ifnti.alafiakidimdigore.Adapter;

import android.content.Context;
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
import com.ifnti.alafiakidimdigore.Helper.ManagementCart;
import com.ifnti.alafiakidimdigore.Interface.ChangeNumberItemsListener;
import com.ifnti.alafiakidimdigore.Modele.Plat;
import com.ifnti.alafiakidimdigore.R;
import java.util.ArrayList;

public class PanierAdapter extends RecyclerView.Adapter<PanierAdapter.ViewHolder> {
    ArrayList<Plat> listFoodSelected;
    private ManagementCart managementCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public PanierAdapter(ArrayList<Plat> listFoodSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listFoodSelected = listFoodSelected;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.affichage_panier, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(listFoodSelected.get(position).getLibelle());
        holder.feeEachItem.setText(listFoodSelected.get(position).getPrix_unitaire() + "f");
        holder.totalEachItem.setText(Math.round((listFoodSelected.get(position).getNumbrerSelectionner() * listFoodSelected.get(position).getPrix_unitaire())) + "f");
        holder.num.setText(String.valueOf(listFoodSelected.get(position).getNumbrerSelectionner()));

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(listFoodSelected.get(position).getImage_plats(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);

        holder.plusItem.setOnClickListener(v -> managementCart.plusNumberFood(listFoodSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));

        holder.minusItem.setOnClickListener(v -> managementCart.minusNumberFood(listFoodSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));
    }

        @Override
    public int getItemCount() {
        return listFoodSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
            num = itemView.findViewById(R.id.numberItemTxt);
        }
    }
    }
