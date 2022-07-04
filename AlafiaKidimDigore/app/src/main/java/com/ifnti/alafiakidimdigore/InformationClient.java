package com.ifnti.alafiakidimdigore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.common.api.Api;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ifnti.alafiakidimdigore.Modele.Client;

public class InformationClient extends AppCompatActivity {
    private EditText textnom, textprenom, textcontact, textaddresse;
    private Button btnValide;
    private Button btnAfficher;
    private String nom, prenom, contact, addresse;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_client);

        db = FirebaseFirestore.getInstance();
        textnom = findViewById(R.id.nom);
        textprenom = findViewById(R.id.prenom);
        textcontact = findViewById(R.id.contact);
        textaddresse = findViewById(R.id.addresse);
        btnValide = findViewById(R.id.btnValide);
        btnAfficher = findViewById(R.id.btnAfficher);

        btnValide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom = textnom.getText().toString();
                prenom = textprenom.getText().toString();
                contact = textcontact.getText().toString();
                addresse = textaddresse.getText().toString();

                if (TextUtils.isEmpty(nom)) {
                    textnom.setError("Svp entrez votre nom");
                } else if (TextUtils.isEmpty(prenom)) {
                    textprenom.setError("Svp entrez votre prenom");
                } else if (TextUtils.isEmpty(contact)) {
                    textcontact.setError("Svp entrez votre contact");
                } else if (TextUtils.isEmpty(addresse)) {
                    textaddresse.setError("Svp entrez votre addresse");
                } else {
                    enregistrerClient(nom, prenom, contact, addresse);
                }
            }
        });

        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InformationClient.this,AfficherClient.class);
                startActivity(i);
            }
        });
    }

    private void enregistrerClient(String nom, String prenom, String contact, String addresse) {
        CollectionReference dbClient = db.collection("Client");

        Client client = new Client(nom, prenom, contact, addresse);

        dbClient.add(client).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(InformationClient.this, "Les données du client sont enrégistrés avec succès", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(InformationClient.this, "Echec d'enregitrement des données" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}