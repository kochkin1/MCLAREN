package com.example.pokup_fra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>{

    private ArrayList<String> shoppingList;

    public  ShoppingListAdapter(ArrayList<String> shoppingList){
        this.shoppingList = shoppingList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        String item = shoppingList.get(position);
        holder.textView.setText(item);
    }
    @Override
    public int getItemCount(){
        return shoppingList.size();
    }

    public  static class  ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public ViewHolder(View view){
            super(view);
            textView = view.findViewById(android.R.id.text1);
        }
    }

}
