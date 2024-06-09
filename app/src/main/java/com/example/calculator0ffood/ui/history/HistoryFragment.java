package com.example.calculator0ffood.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.calculator0ffood.databinding.FragmentHistoryBinding;

public class HistoryFragment extends Fragment {

private FragmentHistoryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel homeViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

    binding = FragmentHistoryBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}