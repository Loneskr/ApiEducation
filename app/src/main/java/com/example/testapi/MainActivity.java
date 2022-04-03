package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapi.Handlers.ApiHandler;
import com.example.testapi.Network.IApiService;
import com.example.testapi.Response.TaskResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private IApiService service = ApiHandler.getInstance().getService();
    private ArrayList<String> taskResponses;
    private String activity;
    private TextView txtActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtActivity = findViewById(R.id.txtActivity);
        getTask();
    }

    private void getTask() {
        AsyncTask.execute(() -> {
            service.getTasks().enqueue(new Callback<TaskResponse>() {
                @Override
                public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                    Toast.makeText(MainActivity.this, "qwertyuiop", Toast.LENGTH_SHORT).show();
                    activity = response.body().getActivity();
                    txtActivity.setText(activity);
                }

                @Override
                public void onFailure(Call<TaskResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "123456789", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}