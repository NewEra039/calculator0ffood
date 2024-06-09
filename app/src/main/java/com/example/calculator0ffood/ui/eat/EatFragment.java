package com.example.calculator0ffood.ui.eat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.calculator0ffood.databinding.FragmentEatBinding;

public class EatFragment extends Fragment {

    private FragmentEatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EatViewModel homeViewModel =
                new ViewModelProvider(this).get(EatViewModel.class);

        binding = FragmentEatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}