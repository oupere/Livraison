package com.ifnti.alafiakidimdigore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ifnti.alafiakidimdigore.Adapter.PanierAdapter;
import com.ifnti.alafiakidimdigore.Helper.ManagementCart;
import com.ifnti.alafiakidimdigore.Interface.ChangeNumberItemsListener;

public class PanierActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double tax;
    private ScrollView scrollView;
    private TextView commander;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

        managementCart = new ManagementCart(this);

        initView();
        initList();
        bottomNavigation();
        calculateCard();
        infoClient();
    }

    private void infoClient() {
        TextView commander = findViewById(R.id.textView16);
        commander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PanierActivity.this, InformationClient.class));
            }
        });
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PanierActivity.this, HomeClient.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PanierActivity.this, PanierActivity.class));
            }
        });
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new PanierAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });
        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
       // double percentTax = 0.02;
        //double delivery = 10;
        double delivery = 0;
       // tax = Math.round((managementCart.getMontantTotal() * percentTax) * 100.0) / 100.0;
        double total = Math.round((managementCart.getMontantTotal() + tax + delivery) * 100.0) / 100.0;
        double itemTotal = Math.round(managementCart.getMontantTotal() * 100.0) / 100.0;
        totalFeeTxt.setText(itemTotal + "f" );
       // taxTxt.setText(tax + "f" );
       // deliveryTxt.setText(delivery + "f" );
        totalTxt.setText(total + "f");
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.view);
        scrollView = findViewById(R.id.scrollView);
        emptyTxt = findViewById(R.id.emptyTxt);
    }
































}