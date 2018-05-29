package com.example.roman.todolistandroidapp.ui.fragments.goalsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.roman.todolistandroidapp.R;
import com.example.roman.todolistandroidapp.data.network.requests.models.Goal;

import java.util.ArrayList;

/**
 * Created by Roman on 26.05.2018.
 */

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.ViewHolder>{
    private ArrayList<Goal> goalArrayList = new ArrayList<>();
    Context mContext;
    public GoalsAdapter(ArrayList<Goal> goalArrayList) {
        this.goalArrayList = goalArrayList;
    }

    @Override
    public GoalsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goal_item, parent, false);
        GoalsAdapter.ViewHolder holder = new GoalsAdapter.ViewHolder(view);
        mContext = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(GoalsAdapter.ViewHolder holder, final int position) {
        final Goal goal=goalArrayList.get(position);
        holder.title.setText(goal.getTitle());
    }

    @Override
    public int getItemCount() {
        return goalArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            relativeLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
