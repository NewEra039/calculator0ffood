package com.example.calculator0ffood.ui.profile;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.calculator0ffood.databinding.FragmentProfileBinding;
import com.example.loginregister.login.LoginViewModel;
import com.example.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Calendar currentDate;
    private User user;
    private Bitmap foto;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        LoginViewModel loginViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        loginViewModel.getUser().observe(getViewLifecycleOwner(),value->{
            user=value;
            binding.userEmail.setText(value.getEmail());
            binding.userFio.setText(user.getFio());
            int year = currentDate.get(Calendar.YEAR);
            int month = currentDate.get(Calendar.MONTH);
            int day = currentDate.get(Calendar.DAY_OF_MONTH);
            binding.userWeight.setText(Double.toString(user.getWeight()));
            binding.userHeight.setText(Double.toString(user.getHeight()));
        });
        binding.saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    user.setFio(binding.userFio.getText().toString());
                    user.setHeight(Double.parseDouble(binding.userHeight.getText().toString()));
                    user.setWeight(Double.parseDouble(binding.userWeight.getText().toString()));
                    loginViewModel.SaveData(user);
                }
            });
        ActivityResultLauncher<Intent> startForResultCamera = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent intent = result.getData();
                            intent.putExtra("content", "camera");
                            Bundle extras = result.getData().getExtras();
                            foto = (Bitmap) extras.get("data");
                            binding.profileImage.setImageBitmap(foto);
                        }
                    }
                });
        binding.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startForResultCamera.launch(takePictureIntent);
                } catch (ActivityNotFoundException e) {
                }
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