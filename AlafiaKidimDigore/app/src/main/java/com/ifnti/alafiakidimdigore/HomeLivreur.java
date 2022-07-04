package com.ifnti.alafiakidimdigore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeLivreur extends AppCompatActivity {
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_livreur);
        changeActivity();
        passerCommande();
    }

    public void changeActivity(){
        b1 = findViewById(R.id.livraison);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(HomeLivreur.this, CommandeEncours.class);
                startActivity(in);
            }
        });
    }

    public void passerCommande() {
        b2 = findViewById(R.id.commande);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(HomeLivreur.this, HomeClient.class);
                startActivity(in);
            }
        });
    }
}