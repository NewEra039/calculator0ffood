package com.example.calculator0ffood.ui.history;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.model.AuthAppRepository;
import com.example.model.Eat;
import com.example.model.SumTypeOfEat;
import com.example.model.TypeOfEat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class HistoryViewModel extends AndroidViewModel {
    private MutableLiveData<List<SumTypeOfEat>> eatList;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference dbRef;
    private AuthAppRepository repository;
    private FirebaseAuth mAuth;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        repository=new AuthAppRepository(application);
        eatList=new MutableLiveData<>();
        this.firebaseDatabase=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();
    }
    public MutableLiveData<List<SumTypeOfEat>> getEatList()
    {
        List<SumTypeOfEat> list=new ArrayList<>();
        FirebaseUser user = mAuth.getCurrentUser();
        Query myTopPostsQuery =this.firebaseDatabase.getReference("users/"+user.getUid().toString());
        myTopPostsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Eat> listEat=new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Eat eat=postSnapshot.getValue(Eat.class);
                    listEat.add(eat);
                }
                Map<Date,Double> eatsByDate=listEat.stream().collect(Collectors.groupingBy(Eat::getDate,
                        Collectors.summingDouble(Eat::getCalories)));
                for(Map.Entry<Date,Double> item:eatsByDate.entrySet())
                {
                     SumTypeOfEat sumTypeOfEat=new SumTypeOfEat(item.getKey(), item.getValue());
                     list.add(sumTypeOfEat);
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