package com.example.inventory.iu.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventory.R;
import com.example.inventory.data.model.Dependency;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;


public class DependencyAdapter extends RecyclerView.Adapter<DependencyAdapter.ViewHolder> {

    private List<Dependency> list;

    public DependencyAdapter(List<Dependency> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dependency,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iconLetter.setLetter(list.get(position).getShortname());
        holder.tvShortName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Método que actualiza los datos del RecyclerView y se DEBE llamar al método notify
     * para que la vista se anule y se vuelva a dibujar
     */
    public void update(List<Dependency> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        MaterialLetterIcon iconLetter;
        TextView tvShortName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconLetter =itemView.findViewById(R.id.iconLetter);
            tvShortName = itemView.findViewById(R.id.tvShortName);
        }
    }
}
