package com.ifnti.alafiakidimdigore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ifnti.alafiakidimdigore.Helper.ManagementCart;
import com.ifnti.alafiakidimdigore.Modele.Plat;

public class DetailsActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt, totalPriceTxt, starTxt, caloryTxt, timeTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private Plat object;
    private int numberOrder = 1;
    private ManagementCart managementCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        managementCart = new ManagementCart(this);

        iniView();
        getBundle();
    }

    private void getBundle() {
        object = (Plat) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getImage_plats(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTxt.setText(object.getLibelle());
        feeTxt.setText(object.getPrix_unitaire() + "f");
        descriptionTxt.setText(object.getDetail_plats());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        caloryTxt.setText(object.getCalories() + " Calories");
        starTxt.setText(object.getStar() + "");
        timeTxt.setText(object.getTemps() + " minutes");
        totalPriceTxt.setText(Math.round(numberOrder * object.getPrix_unitaire()) + "f");

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText(Math.round(numberOrder * object.getPrix_unitaire()) + "f");
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }

                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText(Math.round(numberOrder * object.getPrix_unitaire()) + "f");
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumbrerSelectionner(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

        private void iniView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberItemTxt);
        plusBtn = findViewById(R.id.plusCardBtn);
        minusBtn = findViewById(R.id.minusCardBtn);
        picFood = findViewById(R.id.foodPic);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);
        starTxt = findViewById(R.id.starTxt);
        caloryTxt = findViewById(R.id.VicaloriesTxt);
        timeTxt = findViewById(R.id.timeTxt);
    }
}