package com.example.calculator0ffood.ui.today;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.calculator0ffood.R;
import com.example.calculator0ffood.databinding.FragmentTodayBinding;
import com.example.model.TypeOfEat;

public class TodayFragment extends Fragment {
    private NavController navController;
    private FragmentTodayBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TodayViewModel dashboardViewModel =
                new ViewModelProvider(this).get(TodayViewModel.class);

        binding = FragmentTodayBinding.inflate(inflater, container, false);
        navController= Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        View root = binding.getRoot();
        binding.zavtrak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Bundle bundle = new Bundle();
               bundle.putString("type",TypeOfEat.breakfast.toString());
               navController.navigate(R.id.navigation_eat,bundle);
            }
        });
        binding.obed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("type",TypeOfEat.dinner.toString());
                navController.navigate(R.id.navigation_eat,bundle);
            }
        });
        binding.ujin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("type",TypeOfEat.supper.toString());
                navController.navigate(R.id.navigation_eat,bundle);
            }
        });
        binding.perekus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("type",TypeOfEat.snack.toString());
                navController.navigate(R.id.navigation_eat,bundle);
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