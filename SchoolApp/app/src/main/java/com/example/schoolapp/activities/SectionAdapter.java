package com.example.schoolapp.activities;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.R;

import java.util.ArrayList;

public class SectionAdapter extends RecyclerView.Adapter {

    ArrayList<Section> sArray;
    Context context;

    public SectionAdapter(ArrayList<Section> sArray, Context context) {
        this.sArray = sArray;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //connecting to movie_list_item xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_list_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).eduLevel.setText(sArray.get(position).getEduLevel()+"");
        ((ViewHolder) holder).name.setText(sArray.get(position).getName()+"");
        ((ViewHolder) holder).img.setImageResource(sArray.get(position).getImg());
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(context,Details.class);
                s.putExtra("StudentD",sArray.get(position));
                context.startActivity(s);
            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        ((ViewHolder)holder).tot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Delete");
                builder.setMessage("Are you sure!!!");
                builder.setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sArray.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"hoooo",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return sArray.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView eduLevel;
        public TextView name;
        public ImageView img;
        public ImageView tot;
        public View view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView; //مهم جدا
            eduLevel = itemView.findViewById(R.id.edu);
            name = itemView.findViewById(R.id.sname);
            img = itemView.findViewById(R.id.imageView);
            tot = itemView.findViewById(R.id.tot);
        }
    }
}
