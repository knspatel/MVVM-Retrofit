package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Android;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;

import java.util.ArrayList;

public class ActivityGetAdapter extends RecyclerView.Adapter<ActivityGetAdapter.ViewHolder> {


    private Context context;
    ArrayList<Android> mList;

    public ActivityGetAdapter(Context context, ArrayList<Android> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ActivityGetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new ActivityGetAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityGetAdapter.ViewHolder viewHolder, int i) {
        Android android = mList.get(i);
        viewHolder.tv_name.setText(android.getName());
        viewHolder.tv_version.setText(android.getVer());
        viewHolder.tv_api_level.setText(android.getApi());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView tv_name,tv_version ,tv_api_level;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name=(TextView) itemView.findViewById(R.id.tv_name);
            tv_version=(TextView) itemView.findViewById(R.id.tv_version);
            tv_api_level=(TextView) itemView.findViewById(R.id.tv_api_level);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
          
        }
    }
    
}
