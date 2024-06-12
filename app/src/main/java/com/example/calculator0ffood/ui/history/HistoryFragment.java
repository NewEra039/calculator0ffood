package com.example.calculator0ffood.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.calculator0ffood.databinding.FragmentHistoryBinding;
import com.example.calculator0ffood.ui.eat.EatAdapter;

import java.util.Date;

public class HistoryFragment extends Fragment {

private FragmentHistoryBinding binding;
private HistoryViewModel historyViewModel;
private HistoryAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        historyViewModel.getEatList().observe(getViewLifecycleOwner(), value->{
            adapter=new HistoryAdapter(getActivity(),value);
            binding.history.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.history.setAdapter(adapter);
        });
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}