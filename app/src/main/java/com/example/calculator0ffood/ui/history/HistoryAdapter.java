package com.example.calculator0ffood.ui.history;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculator0ffood.R;
import com.example.model.Eat;
import com.example.model.SumTypeOfEat;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>
{
    private List<SumTypeOfEat> eats;
    public HistoryAdapter(@NonNull Context context, List<SumTypeOfEat> list) {
        this.eats=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new ViewHolder(view);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SumTypeOfEat eat = eats.get(position);
        holder.history_data.setText(eat.getData().getDate()+"."+
                eat.getData().getMonth()+"."+eat.getData().getDate());
        holder.history_colory.setText(Double.toString(eat.getSumColories()));
    }
    @Override
    public int getItemCount() {
        return eats.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView history_data, history_colory;
        ViewHolder(View view){
            super(view);
            history_data = view.findViewById(R.id.history_data);
            history_colory = view.findViewById(R.id.history_colory);
        }
    }
}
