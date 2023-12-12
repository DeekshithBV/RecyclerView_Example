package com.example.cardview;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context mContext;
    ArrayList<ContactModel> arrContacts;

    public List<Integer> selectedPositions = new ArrayList<>();
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.mContext=context;
        this.arrContacts=arrContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);
    }
    int globalPosition;
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);

        if(position==globalPosition) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext,R.color.black));

        }
        else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext, android.R.color.transparent));
        }

        if (selectedPositions.contains(position)){
            holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext,R.color.black));
        }
        else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext, android.R.color.transparent));
        }

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    private void toggleSelection(int position){
        if (selectedPositions.contains(position)){
            selectedPositions.remove(Integer.valueOf(position));
        }
        else {
            selectedPositions.add(position);
        }
        notifyDataSetChanged();
        updateItemCount();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtNumber;
        ImageView imgContact;
        Button button;

        public ViewHolder(View itemView){
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
            button = itemView.findViewById(R.id.buttonActivity);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ContactModel clickedContact = arrContacts.get(position);
                        String message = "Clicked on " + clickedContact.name;
                        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    globalPosition=getAdapterPosition();
                    notifyDataSetChanged();
                    return false;
                }
            });

            itemView.setOnLongClickListener(view -> {
                int position = getAdapterPosition();
                toggleSelection(position);
                return false;
            });

            button.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, SecondaryActivity.class);
                Bundle bundle = new Bundle();
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    ContactModel clickedContact = arrContacts.get(position);
                    String message = clickedContact.name;
                    String number = clickedContact.number;
                    Log.e("Deek", "ViewHolder: " + message);
                    bundle.putString("Name",message);
                    bundle.putString("Number",number);
                    intent.putExtras(bundle);
                }
                startActivity(mContext , intent , bundle);
            });
        }

    }

    public void selectItem(int position) {
        selectedPositions.add(position);
        notifyItemChanged(position);
        updateItemCount();
    }

    public void deselectItem(int position) {
        selectedPositions.remove(Integer.valueOf(position));
        notifyItemChanged(position);
        updateItemCount();
    }

    public int getSelectedItemCount() {
        return selectedPositions.size();
    }

    private void updateItemCount() {
        // Call this method whenever the selected item count changes
        if (mContext instanceof MainActivity) {
            ((MainActivity) mContext).selItemCount.setText(String.valueOf(getSelectedItemCount()));
        }
    }

    public void clearSelectedItems() {
        selectedPositions.clear();
        notifyDataSetChanged();
        updateItemCount(); // Update count when items are cleared
    }
}
