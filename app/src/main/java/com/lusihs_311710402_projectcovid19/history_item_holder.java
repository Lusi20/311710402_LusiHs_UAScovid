package com.lusihs_311710402_projectcovid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lusihs_311710402_projectcovid19.model.RiwayatModel;

import java.util.ArrayList;

public class history_item_holder extends RecyclerView.Adapter<history_item_holder.ViewHolder> {

    private ArrayList<RiwayatModel> riwayatModels = new ArrayList<>();
    private Context context;

    public history_item_holder(Context context) {
        this.context = context;
    }

    public ArrayList<RiwayatModel> getRiwayatModels() {
        return riwayatModels;
    }

    public void setRiwayatModels(ArrayList<RiwayatModel> items) {
        if (riwayatModels != null) {
            if (riwayatModels.size() > 0) {
                riwayatModels.clear();
            }
            riwayatModels.addAll(items);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lastUpdateDate.setText(riwayatModels.get(position).getLastUpdate());
        holder.tvConfirmed.setText(riwayatModels.get(position).getConfirmed());
        holder.tvRecovered.setText(riwayatModels.get(position).getRecovered());
        holder.tvDeath.setText(riwayatModels.get(position).getDeaths());
        holder.tvListCountry.setText("Negara : " + riwayatModels.get(position).getCountryRegion());
    }

    @Override
    public int getItemCount() {
        return riwayatModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lastUpdateDate;
        TextView tvConfirmed;
        TextView tvRecovered;
        TextView tvDeath;
        TextView tvListCountry;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            lastUpdateDate = itemView.findViewById(R.id.tvListLastUpdate);
            tvConfirmed = itemView.findViewById(R.id.tvListConfirmed);
            tvRecovered = itemView.findViewById(R.id.tvListRecovered);
            tvDeath = itemView.findViewById(R.id.tvListDeath);
            tvListCountry = itemView.findViewById(R.id.tvListCountry);
        }
    }
}

