package com.example.pokup_fra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListFragment extends Fragment {

    private RecyclerView recyclerView;

    private  ShoppingListAdapter adapter;

    private ArrayList<String> shoppingList;

    @Nullable
    @Override
    public View  onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        //подключаем макет для фрагмента
        View view = inflater.inflate(R.layout.fragment_shopping_list,container, false);
        //инициализация списка покупок
        shoppingList = new ArrayList<>();
        shoppingList.add("Bread");
        shoppingList.add("Butter");
        shoppingList.add("Potatoes");

        //Инициализация RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        adapter = new ShoppingListAdapter(shoppingList);
        recyclerView.setAdapter(adapter);

        return view;

    }
    public void addItem(String item){
        shoppingList.add(item);
        adapter.notifyDataSetChanged();
    }
}
