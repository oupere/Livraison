package com.ifnti.alafiakidimdigore.Helper;

import android.content.Context;
import android.widget.Toast;

import com.ifnti.alafiakidimdigore.Modele.Plat;
import com.ifnti.alafiakidimdigore.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(Plat item) {
        ArrayList<Plat> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getLibelle().equals(item.getLibelle())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if (existAlready) {
            listFood.get(n).setNumbrerSelectionner(item.getNumbrerSelectionner());
        } else {
            listFood.add(item);
        }
        tinyDB.putListObject("CardList", listFood);
        Toast.makeText(context, "Ajouttez à votre panier ?", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Plat> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberFood(ArrayList<Plat> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listfood.get(position).getNumbrerSelectionner() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumbrerSelectionner(listfood.get(position).getNumbrerSelectionner() - 1);
        }
        tinyDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<Plat> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setNumbrerSelectionner(listfood.get(position).getNumbrerSelectionner() + 1);
        tinyDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getMontantTotal() {
        ArrayList<Plat> listfood2 = getListCart();
        double prix_unitaire = 0;
        for (int i = 0; i < listfood2.size(); i++) {
            prix_unitaire = prix_unitaire + (listfood2.get(i).getPrix_unitaire() * listfood2.get(i).getNumbrerSelectionner());
        }
        return prix_unitaire;
    }
}
