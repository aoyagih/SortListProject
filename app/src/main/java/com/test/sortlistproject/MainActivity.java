package com.test.sortlistproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Notebook");
    private CollectionReference notebookRef2 = db.collection("Notebook2");

    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecyclerView1();
    }

    private void setUpRecyclerView1(){
        Query query = notebookRef.orderBy("fromIkebukuro", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<Station> options = new FirestoreRecyclerOptions.Builder<Station>()
                .setQuery(query, Station.class)
                .build();

        adapter = new ItemAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    /*
    public void sort1(View v){
        setUpRecyclerView1();
    }
    public void sort2(View v){
        Query query2 = notebookRef2.orderBy("fromIkebukuro", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<Station> options = new FirestoreRecyclerOptions.Builder<Station>()
                .setQuery(query2, Station.class)
                .build();

        adapter = new ItemAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    public void sort3(View v){
        Query query = notebookRef.orderBy("fromIkebukuro", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<Station> options = new FirestoreRecyclerOptions.Builder<Station>()
                .setQuery(query, Station.class)
                .build();

        adapter = new ItemAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
     */

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
