package com.example.calculator0ffood.ui.eat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.calculator0ffood.databinding.FragmentAddEatBinding;
import com.example.model.Eat;
import com.example.model.TypeOfEat;

import java.util.Date;


public class AddEatFragment extends Fragment {
    private FragmentAddEatBinding binding;
    private EatViewModel eatViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        eatViewModel = new ViewModelProvider(this).get(EatViewModel.class);
        binding = FragmentAddEatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        String arg1Value = getArguments().getString("type");
        binding.tvTypeOfEat.setText(arg1Value);
        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eatViewModel.addEat(new Eat(new Date(),
                        TypeOfEat.breakfast,
                        binding.nameEat.getText().toString(),
                        Double.parseDouble(binding.protein.getText().toString()),
                                Double.parseDouble(binding.fat.getText().toString()),
                                Double.parseDouble(binding.carbs.getText().toString()),
                        Double.parseDouble(binding.calories.getText().toString())));
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}