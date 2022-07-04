package com.ifnti.alafiakidimdigore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.ifnti.alafiakidimdigore.Adapter.ClientAdapter;
import com.ifnti.alafiakidimdigore.Modele.Client;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

public class AfficherClient extends AppCompatActivity {
    private RecyclerView clientRV;
    private ArrayList<Client> listClients;
    private ClientAdapter clientAdapter;
    private FirebaseFirestore db;
    ProgressBar loadingPB;
    private Object ClientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_client);

        clientRV = findViewById(R.id.idRVCourses);
        loadingPB = findViewById(R.id.idProgressBar);
        db = FirebaseFirestore.getInstance();

        listClients = new ArrayList<>();
        clientRV.setHasFixedSize(true);
        clientRV.setLayoutManager(new LinearLayoutManager(this));

        ClientAdapter = new ClientAdapter(listClients, this);

        clientRV.setAdapter(clientAdapter);

        db.collection("Client").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    loadingPB.setVisibility(View.GONE);
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : list) {
                        Client c = d.toObject(Client.class);
                        listClients.add(c);
                    }
                } else {
                    Toast.makeText(AfficherClient.this, "Pas de clients inscrits dans la base", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AfficherClient.this, "Echec d'obtention de donnée.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
