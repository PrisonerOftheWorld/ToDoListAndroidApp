package com.example.roman.todolistandroidapp.ui.supportView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;

import com.example.roman.todolistandroidapp.R;
import com.example.roman.todolistandroidapp.data.network.requests.RetrofitService;
import com.example.roman.todolistandroidapp.data.network.requests.models.GoalCreateRequestBody;
import com.example.roman.todolistandroidapp.data.network.requests.models.GoalCreateResponseBody;
import com.example.roman.todolistandroidapp.data.network.requests.services.ApiRequests;
import com.example.roman.todolistandroidapp.ui.MainActivity;
import com.example.roman.todolistandroidapp.ui.fragments.GoalsFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class CustomDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    private EditText getEditText;
    MainActivity callBackActivity;
    CustomDialogInterface customDI;
    private FragmentActivity myContext;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }
    public CustomDialogFragment(CustomDialogInterface customDI)
    {
        this.customDI = customDI;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        callBackActivity = new MainActivity();
        getEditText = new EditText(getActivity());
        getEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Enter The title :");
        builder.setPositiveButton("Ok", this);
        builder.setNegativeButton("Cancel", null);
        builder.setView(getEditText);
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String value = getEditText.getText().toString();
        Log.d("title : ", value);
        RetrofitService.createService(ApiRequests.class).createGoal(new GoalCreateRequestBody(value)).enqueue(new Callback<GoalCreateResponseBody>() {
            @Override
            public void onResponse(Call<GoalCreateResponseBody> call, Response<GoalCreateResponseBody> response) {
                if(response.isSuccessful()){
                    System.out.println("eeeeeeeeeeeeeeeeeeee");
                    System.out.println(response.body().getId());
//                    FragmentManager fragManager = myContext.getSupportFragmentManager();
//
//                    GoalsFragment frg = (GoalsFragment) fragManager.findFragmentByTag("goal_fragment_container");
//                    final FragmentTransaction ft = fragManager.beginTransaction();
//                    ft.detach(frg);
//                    ft.attach(frg);
//                    ft.commit();
                }
            }

            @Override
            public void onFailure(Call<GoalCreateResponseBody> call, Throwable t) {

            }
        });


        dialog.dismiss();
        customDI.okButtonClicked(value);


    }
}