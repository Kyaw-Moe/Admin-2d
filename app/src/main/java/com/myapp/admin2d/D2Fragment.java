package com.myapp.admin2d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myapp.admin2d.adapter.D2Adapter;
import com.myapp.admin2d.models.D2;

import java.util.ArrayList;

public class D2Fragment extends Fragment {

    RecyclerView recyclerView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public D2Fragment() {
        // Required empty public constructor
    }

    FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Context context = container.getContext();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_d2, container, false);
        recyclerView = view.findViewById(R.id.rcv_2d);
        floatingActionButton = view.findViewById(R.id.fab_add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, D2FormActivity.class);
                startActivity(intent);
            }
        });
        db.collection(getString(R.string.parth))
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        final ArrayList<D2> d2ArrayList = new ArrayList<>();
                        for (QueryDocumentSnapshot doc: queryDocumentSnapshots) {
                             d2ArrayList.add(doc.toObject(D2.class));
                        }
                        D2Adapter adapter = new D2Adapter();
                        recyclerView.setAdapter(adapter);

                        recyclerView.setHasFixedSize(true);
                        LinearLayoutManager manager = new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
                        recyclerView.setLayoutManager(manager);

                    }
                });


        return view;
    }
}