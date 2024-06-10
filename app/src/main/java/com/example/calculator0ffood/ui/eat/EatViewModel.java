package com.example.calculator0ffood.ui.eat;

import android.app.Application;
import android.hardware.lights.LightsManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.model.AuthAppRepository;
import com.example.model.Eat;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class EatViewModel extends AndroidViewModel {
    private MutableLiveData<List<Eat>> eatList;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference dbRef;
    private AuthAppRepository repository;


    public EatViewModel(@NonNull Application application) {
        super(application);
        repository=new AuthAppRepository(application);
        eatList=new MutableLiveData<>();
        this.firebaseDatabase=FirebaseDatabase.getInstance();
    }
    public void addEat(Eat eat)
    {
        FirebaseUser user=repository.getUserLiveData().getValue();
        dbRef=this.firebaseDatabase.getReference("users/"+user.getUid().toString());
        String eated = dbRef.push().getKey();
        dbRef.child(eated).setValue(eat);
    }
    public void addEatList(List<Eat> eats){
        eatList.setValue(eats);
    }
    public MutableLiveData<List<Eat>> getEatList()
    {
        return eatList;
    }
}