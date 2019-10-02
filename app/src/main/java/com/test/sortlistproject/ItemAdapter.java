package com.test.sortlistproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ItemAdapter extends FirestoreRecyclerAdapter<Station, ItemAdapter.ItemHolder> {

    public ItemAdapter(@NonNull FirestoreRecyclerOptions<Station> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ItemHolder holder, int position, @NonNull Station model) {
        if(model.isExpress()){
            holder.textViewName.setText(model.getName());
        }else {
            holder.textViewName.setText(model.getName());
        }
        if(model.getFromIkebukuro()<=0){
            holder.textViewStation.setText("F0"+ String.valueOf(model.getFromIkebukuro()+9));
        }else {
            holder.textViewStation.setText("F" + String.valueOf(model.getFromIkebukuro()+9));
        }
    }



    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,
                parent, false);
        return new ItemHolder(v);
    }



    class ItemHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewStation;

        public ItemHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.item_name);
            textViewStation = itemView.findViewById(R.id.item_number);
        }
    }


}