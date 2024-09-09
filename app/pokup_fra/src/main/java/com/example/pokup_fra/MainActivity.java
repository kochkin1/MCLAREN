package com.example.pokup_fra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements com.example.pokup_fra.AddItemFragment.OnNewItemAddedListener {

    private ShoppingListFragment shoppingListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){

            shoppingListFragment = new ShoppingListFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.shopping_list_container, shoppingListFragment);

            AddItemFragment addItemFragment = new AddItemFragment();
            transaction.add(R.id.add_item_container, addItemFragment);

            transaction.commit();
        }
    }

    @Override
    public void onNewItemAdded(String item){
        shoppingListFragment.addItem(item);
    }
}