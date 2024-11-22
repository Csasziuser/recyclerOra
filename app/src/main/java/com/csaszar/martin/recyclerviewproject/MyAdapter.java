package com.csaszar.martin.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    // ViewHolder osztály: Az egyes elemek nézeteinek létrehozása és újrahasznosítása
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        // Nézetek hozzákötése a ViewHolderhez
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    // Az adatok, amiket megjelenítünk (nevek listája)
    private List<String> nameList;

    // Adatok átadása
    public MyAdapter(List<String> nameList) {
        this.nameList = nameList;
    }

    //RecyclerView.Adapter... osztály metódusainek implementálása

    //Új nézet létrehozása a sablonunk (recycler_item.xml) alapján
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(itemView);
    }

    //Adatok hozzárendelése a nézethez
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = nameList.get(position);
    }

    //ez határozza meg, hogy hányszor kell végrehajtani a nézetlétrehozást
    @Override
    public int getItemCount() {
        return nameList.size();
    }
}
