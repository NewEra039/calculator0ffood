package com.example.calculator0ffood.ui.eat;

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
import com.example.calculator0ffood.databinding.FragmentEatBinding;
import com.example.model.TypeOfEat;

public class EatListFragment extends Fragment {
    private NavController navController;
    private FragmentEatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EatViewModel homeViewModel =
                new ViewModelProvider(this).get(EatViewModel.class);
        navController= Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        binding = FragmentEatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.fabAddEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("type", TypeOfEat.breakfast.toString());
                navController.navigate(R.id.navigation_eatAdd,bundle);
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