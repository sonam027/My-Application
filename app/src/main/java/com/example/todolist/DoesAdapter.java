package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyDoes> myDoes;
    public DoesAdapter(Context c, ArrayList<MyDoes> p){
        context = c;
        myDoes=p;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tittledoes.setText(myDoes.get(i).getTitledoes());
        myViewHolder.descdoes.setText(myDoes.get(i).getDescdoes());
        myViewHolder.datedoes.setText(myDoes.get(i).getDatedoes());

        final String getTitleDoes=myDoes.get(i).getTitledoes();
        final String getDescDoes=myDoes.get(i).getDescdoes();
        final String getDateDoes=myDoes.get(i).getDatedoes();
        final String getKeyDoes=myDoes.get(i).getKeydoes();
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aa=new Intent(context, EditTaskDesk.class);
                aa.putExtra("titledoes",getTitleDoes);
                aa.putExtra("descdoes",getDescDoes);
                aa.putExtra("datedoes",getDateDoes);
                aa.putExtra("keydoes",getKeyDoes);
                context.startActivity(aa);

            }
        });

    }

    @Override
    public int getItemCount() {
        return myDoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tittledoes, descdoes, datedoes,keydoes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tittledoes=(TextView)itemView.findViewById(R.id.titledoes);
            descdoes=(TextView)itemView.findViewById(R.id.descdoes);
            datedoes=(TextView)itemView.findViewById(R.id.datedoes);
        }
    }
}
