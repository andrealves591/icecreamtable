package com.techonologies.developer.alves.icecreamtable.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.techonologies.developer.alves.icecreamtable.R;
import com.techonologies.developer.alves.icecreamtable.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.line_products,
                parent,
                false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder h = (ViewHolder) holder;

        Product p = products.get(position);

        h.tvName.setText(p.getName());
        h.tvMeasure.setText(R.string.pa_tv_measure + p.getMeasure());
        h.tvValue.setText(R.string.pa_tv_value + String.valueOf(p.getCostValue()));
        h.tvDescription.setText(p.getDescription());
        Picasso.get()
                .load(p.getUrlImage())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(((ViewHolder) holder).imageView);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvMeasure;
        private final TextView tvValue;
        private final TextView tvDescription;
        private final ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.lp_tv_name_product);
            tvDescription = itemView.findViewById(R.id.lp_tv_description);
            tvMeasure = itemView.findViewById(R.id.lp_tv_measure);
            tvValue = itemView.findViewById(R.id.lp_tv_value);
            imageView = itemView.findViewById(R.id.lp_iv_image);
        }
    }
}
