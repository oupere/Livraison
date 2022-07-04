package com.ifnti.alafiakidimdigore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.ifnti.alafiakidimdigore.Adapter.Categorie_Adapter;
import com.ifnti.alafiakidimdigore.Adapter.Plat_Adapter;
import com.ifnti.alafiakidimdigore.Modele.Categorie;
import com.ifnti.alafiakidimdigore.Modele.Plat;

import java.util.ArrayList;

public class HomeClient extends AppCompatActivity {
    private RecyclerView.Adapter categorieAdapter, platAdapter;
    private RecyclerView list_categorie, list_plats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_client);

        listCategorie();
        listPlats();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeClient.this,HomeClient.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeClient.this,PanierActivity.class));
            }
        });

    }

    private void listPlats() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        list_plats = findViewById(R.id.view2);
        list_plats.setLayoutManager(linearLayoutManager);

        ArrayList<Plat> foodlist = new ArrayList<>();
        foodlist.add(new Plat("Pâte de maïs ", 500.0, "motou1", "Pâte de maïs avec sauce adémè, sauce gombo, arachide", 25, 2, 1000));
        foodlist.add(new Plat("Foufou", 1000.0, "foufou2", "Foufou d'igname ou de banane avec sauce tomate, arachide, césame", 24, 3, 1500));
        foodlist.add(new Plat("Salade", 2000.0, "salade1", "Salade de fruits légers", 24, 3, 1500));
        foodlist.add(new Plat("Burger", 2000.0, "mafe", "balaaaaa", 24, 3, 1500));
        foodlist.add(new Plat("Burger", 2000.0, "rice", "balaaaaa", 24, 3, 1500));
        foodlist.add(new Plat("Pizza", 1500.0, "spaghetti2", "blaaa blaaa", 15, 2, 1000));
        foodlist.add(new Plat("Pâte de maïs ", 500.0, "motou2", "Pâte de maïs avec sauce adémè, sauce gombo, arachide", 25, 2, 1000));
        foodlist.add(new Plat("Foufou", 1000.0, "foufou3", "Foufou d'igname ou de banane avec sauce tomate, arachide, césame", 24, 3, 1500));
        foodlist.add(new Plat("Salade", 2000.0, "salade2", "Salade de fruits légers", 24, 3, 1500));

        foodlist.add(new Plat("spaghetti", 2000.0, "spaghetti1", "balaaaaa", 24, 3, 1500));
        foodlist.add(new Plat("Burger", 2000.0, "burger", "balaaaaa", 24, 3, 1500));
        foodlist.add(new Plat("Pizza", 2000.0, "pizza3", "balaaaaa", 24, 3, 1500));
        foodlist.add(new Plat("Drink", 2000.0, "cat_4", "balaaaaa", 24, 3, 1500));
        foodlist.add(new Plat("Hotdog", 2000.0, "login_background2", "balaaaaa", 24, 3, 1500));

        foodlist.add(new Plat("spaghetti", 2000.0, "spaghetti3", "balaaaaa", 24, 3, 1500));

        foodlist.add(new Plat("Pâte de maïs ", 500.0, "foufou1", "Pâte de maïs avec sauce adémè, sauce gombo, arachide", 25, 2, 1000));
        foodlist.add(new Plat("Foufou", 1000.0, "foufou4", "Foufou d'igname ou de banane avec sauce tomate, arachide, césame", 24, 3, 1500));
        foodlist.add(new Plat("Salade", 2000.0, "salade3", "Salade de fruits légers", 24, 3, 1500));
        foodlist.add(new Plat("Salade", 2000.0, "salade4", "Salade de fruits légers", 24, 3, 1500));

        platAdapter = new Plat_Adapter(foodlist);
        list_plats.setAdapter(platAdapter);
    }

    private void listCategorie() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        list_categorie=findViewById(R.id.view1);
        list_categorie.setLayoutManager(linearLayoutManager);
        ArrayList<Categorie> categoryList = new ArrayList<>();
        categoryList.add(new Categorie("Pâte de maïs", "motou2"));
        categoryList.add(new Categorie("Foufou", "foufou4"));
        categoryList.add(new Categorie("Salade", "salade2"));
        categoryList.add(new Categorie("Spaghetti", "spaghetti1"));
        categoryList.add(new Categorie("Viende de Boeuf", "mafe"));
        categoryList.add(new Categorie("Pizza", "pizza3"));
        categoryList.add(new Categorie("Burger", "burger"));
        categoryList.add(new Categorie("pizza1", "cat_1"));
        categoryList.add(new Categorie("Riz pqrfumé Délice", "rice"));
        categoryList.add(new Categorie("Hotdog", "login_background2"));
        categoryList.add(new Categorie("Drink", "cat_4"));
        categoryList.add(new Categorie("Donut", "cat_5"));

        categorieAdapter = new Categorie_Adapter(categoryList);
        list_categorie.setAdapter(categorieAdapter);
    }























}