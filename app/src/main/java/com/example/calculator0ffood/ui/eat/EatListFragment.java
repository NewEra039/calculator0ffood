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
import com.google.firebase.Firebase;

import java.util.Date;

public class EatListFragment extends Fragment {
    private NavController navController;
    private FragmentEatBinding binding;
    private EatViewModel homeViewModel;
    private String typeOfEat;
    private TypeOfEat type;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(getActivity()).get(EatViewModel.class);
        navController= Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        binding = FragmentEatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if(getArguments()!=null)
        {
            typeOfEat = getArguments().getString("type");
            if(typeOfEat.equals("breakfast")) type=TypeOfEat.breakfast;
            else if(typeOfEat.equals("dinner")) type=TypeOfEat.dinner;
            else if(typeOfEat.equals("supper")) type=TypeOfEat.supper;
            else type=TypeOfEat.snack;
        }
        binding.fabAddEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("type", typeOfEat);
                navController.navigate(R.id.navigation_eatAdd,bundle);
            }
        });
        homeViewModel.getEatList(type,new Date()).observe(getViewLifecycleOwner(), value->{
            EatAdapter adapter=new EatAdapter(getActivity(),value);
            if(binding!=null) binding.rvMeals.setAdapter(adapter);
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}