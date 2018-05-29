package com.example.roman.todolistandroidapp.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roman.todolistandroidapp.R;
import com.example.roman.todolistandroidapp.data.network.requests.RetrofitService;
import com.example.roman.todolistandroidapp.data.network.requests.models.Goal;
import com.example.roman.todolistandroidapp.data.network.requests.models.GoalsList;
import com.example.roman.todolistandroidapp.data.network.requests.services.ApiRequests;
import com.example.roman.todolistandroidapp.ui.fragments.goalsAdapter.GoalsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GoalsFragment extends Fragment {
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        RetrofitService.createService(ApiRequests.class).goals().enqueue(new Callback<GoalsList>() {
            @Override
            public void onResponse(Call<GoalsList> call, Response<GoalsList> response) {
                if (response.isSuccessful()){
                    System.out.println("successful");
                    initRecyclerView(response.body().getGoals(),container);
                }else{
                    System.out.println(response.code());
                }
            }
            @Override
            public void onFailure(Call<GoalsList> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

        return inflater.inflate(R.layout.fragment_goals, container, false);
    }
    private void initRecyclerView(ArrayList<Goal> goals,View view){
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        GoalsAdapter adapter = new GoalsAdapter(goals);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
