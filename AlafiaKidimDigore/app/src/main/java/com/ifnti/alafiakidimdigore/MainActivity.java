package com.ifnti.alafiakidimdigore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnConnect;
    private Button btnDemarer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnect = (Button) findViewById(R.id.btn_connect);
        btnDemarer = (Button) findViewById(R.id.btn_demarer);

       btnConnect.setOnClickListener(v -> {
           Intent seconnecter = new Intent(MainActivity.this, Login.class );
           startActivity(seconnecter);
       });

        btnDemarer.setOnClickListener(v -> {
            Intent demarrer = new Intent(MainActivity.this, HomeClient.class );
            startActivity(demarrer);
        });
    }

}
