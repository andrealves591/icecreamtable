package com.techonologies.developer.alves.icecreamtable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;

public class ProductSuppliersActivity extends AppCompatActivity {

    private TextView tvViewCatalog;
    private Intent it;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_suppliers);

        FirebaseApp.initializeApp(ProductSuppliersActivity.this);

        tvViewCatalog = findViewById(R.id.ps_tv_show_catalog);

        tvViewCatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(ProductSuppliersActivity.this, CatalogActivity.class);
                startActivity(it);
            }
        });

    }
}
