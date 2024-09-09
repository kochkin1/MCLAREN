package com.example.pokup_fra;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddItemFragment extends Fragment {

    private EditText newItemEditText;
    private Button addButton;
    private OnNewItemAddedListener callback;

    public interface OnNewItemAddedListener {
        void onNewItemAdded(String item);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            callback = (OnNewItemAddedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " должна реализовать OnNewItemAddedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adcd_item, container, false);

        newItemEditText = view.findViewById(R.id.new_item_edit_text);
        addButton = view.findViewById(R.id.add_button);

        addButton.setOnClickListener(v -> {
            String newItem = newItemEditText.getText().toString();
            if (!newItem.isEmpty()) {
                callback.onNewItemAdded(newItem);
                newItemEditText.setText("");
            } else {
                Toast.makeText(getActivity(), "Введите элемент", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
