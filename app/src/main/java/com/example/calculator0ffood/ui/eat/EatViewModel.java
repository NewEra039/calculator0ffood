package com.example.calculator0ffood.ui.eat;

import android.app.Application;
import android.hardware.lights.LightsManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.model.AuthAppRepository;
import com.example.model.Eat;
import com.example.model.TypeOfEat;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EatViewModel extends AndroidViewModel {
    private MutableLiveData<List<Eat>> eatList;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference dbRef;
    private AuthAppRepository repository;
    private FirebaseAuth mAuth;

    public EatViewModel(@NonNull Application application) {
        super(application);
        repository=new AuthAppRepository(application);
        eatList=new MutableLiveData<>();
        this.firebaseDatabase=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();

    }
    public void addEat(Eat eat)
    {
        FirebaseUser user=repository.getUserLiveData().getValue();
        dbRef=this.firebaseDatabase.getReference("users/"+user.getUid().toString());
        String eated = dbRef.push().getKey();
        dbRef.child(eated).setValue(eat);
    }
    public MutableLiveData<List<Eat>> getEatList(TypeOfEat typeOfEat, Date date)
    {
        List<Eat> list=new ArrayList<>();
        FirebaseUser user = mAuth.getCurrentUser();
        Query myTopPostsQuery =this.firebaseDatabase.getReference("users/"+user.getUid().toString());
        myTopPostsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Eat eat=postSnapshot.getValue(Eat.class);
                    if(typeOfEat==eat.getTypeOfEat()&&date.getDate()==eat.getDate().getDate()&&
                    date.getMonth()==eat.getDate().getMonth()&&date.getYear()==eat.getDate().getYear())
                        list.add(eat);
                }
                eatList.setValue(list);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return eatList;
    }
}