package com.ifnti.alafiakidimdigore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username;
    EditText telephone;
    Button connecter;
    TextView forget;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        login();
    }

    public  void initialize(){
         username = findViewById(R.id.user_name);
         telephone = findViewById(R.id.tel);
         connecter = findViewById(R.id.btn);
         forget = findViewById(R.id.frget_passwd);

    }
    public void login(){
        connecter.setOnClickListener(v -> {
            if(username.getText().toString().equals("admin") &&
                    telephone.getText().toString().equals("1234")) {
                Intent gerant = new Intent(Login.this, GerantActivity.class);
                startActivity(gerant);
            }
            else if(username.getText().toString().equals("livreur") &&
                        telephone.getText().toString().equals("12345")){
                    Intent in = new Intent(Login.this, HomeLivreur.class);
                    startActivity(in);

            }else{
                Toast.makeText(getApplicationContext(),
                        "Wrong username or phone number",Toast.LENGTH_LONG).show();

                forget.setTextColor(Color.RED);
                //counter--;
                // username.setText(counter);
                if(counter == 0) {
                    connecter.setEnabled(false);
                }

            }

        });

    }
}