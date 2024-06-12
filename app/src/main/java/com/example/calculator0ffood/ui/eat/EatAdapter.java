package com.example.calculator0ffood.ui.eat;

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

import java.util.List;

public class EatAdapter extends RecyclerView.Adapter<EatAdapter.ViewHolder>
{
    private LayoutInflater inflater;
    private List<Eat> eats;
    public EatAdapter(@NonNull Context context, List<Eat> list) {
        this.eats=list;
        if(context!=null)
            this.inflater=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.eat_item, parent, false);
        return new ViewHolder(view);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Eat eat = eats.get(position);
        holder.nameView.setText(eat.getName());
        holder.proteinView.setText(Double.toString(eat.getProtein()));
        holder.fatView.setText(Double.toString(eat.getFat()));
        holder.farbsView.setText(Double.toString(eat.getCarbs()));
        holder.coloryView.setText(Double.toString(eat.getCalories()));
    }
    @Override
    public int getItemCount() {
        return eats.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, proteinView, fatView, farbsView, coloryView;
        ViewHolder(View view){
            super(view);
            proteinView = view.findViewById(R.id.proteinView);
            nameView = view.findViewById(R.id.editTextDishName);
            fatView = view.findViewById(R.id.fatView);
            farbsView=view.findViewById(R.id.farbsView);
            coloryView=view.findViewById(R.id.coloryView);
        }
    }
}
