package com.example.mohammed.lessonsmanagerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.mohammed.lessonsmanagerapp.Adapters.EpisodesAdapter;
import com.example.mohammed.lessonsmanagerapp.Model.ImdbResponse;
import com.example.mohammed.lessonsmanagerapp.Model.InnerResponse;
import com.example.mohammed.lessonsmanagerapp.Network.ImbdEndpoint;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonActivity extends AppCompatActivity implements View.OnClickListener, Callback<ImdbResponse> {
    private RecyclerView recyclerView;
    private EpisodesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;





    @Override
    public void onResponse(Call<ImdbResponse> call, Response<ImdbResponse> response) {
        int code = response.code();
        Toast.makeText(this, "code: " + String.valueOf(code), Toast.LENGTH_LONG).show();
        if (code == 200) {
            ImdbResponse seriesBodyResponse = response.body();
            InnerResponse series = seriesBodyResponse.getResponse();
           mAdapter.updateDataSet(series.getEpisodes());
        } else {
            Toast.makeText(this, "Did not work: " + String.valueOf(code), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<ImdbResponse> call, Throwable t) {
        Toast.makeText(this, "Nope", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        Gson  gson = new GsonBuilder() //parser
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(ImbdEndpoint.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        ImbdEndpoint imdbEndpoint = retrofit.create(ImbdEndpoint.class);

        Call<ImdbResponse> callSeries  = imdbEndpoint.getSeriesByName("How I Met Your Mother");
        callSeries.enqueue(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        setupRecycler();




    }


    private void setupRecycler() {
        recyclerView = (RecyclerView) findViewById(R.id.episodes_recycler);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EpisodesAdapter(this);
        recyclerView.setAdapter(mAdapter);
    }




}
