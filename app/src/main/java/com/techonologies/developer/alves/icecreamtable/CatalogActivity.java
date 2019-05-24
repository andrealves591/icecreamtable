package com.techonologies.developer.alves.icecreamtable;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.techonologies.developer.alves.icecreamtable.adapter.ProductAdapter;
import com.techonologies.developer.alves.icecreamtable.model.Product;

import java.util.ArrayList;

public class CatalogActivity extends AppCompatActivity {
    private RecyclerView rvProducts;
    private ProductAdapter adapter;

    private ProgressBar progressCircle;

    private DatabaseReference mDatabaseRef;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_catalog);

        progressCircle = findViewById(R.id.pc_progress_catalog);
        rvProducts = findViewById(R.id.pc_rv_catalog);
        rvProducts.setHasFixedSize(true);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));

        products = new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("alvestec");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Product p = postSnapshot.getValue(Product.class);
                    products.add(p);
                }

                adapter = new ProductAdapter(CatalogActivity.this, products);

                rvProducts.setAdapter(adapter);
                progressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}