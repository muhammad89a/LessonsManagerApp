package com.example.mohammed.lessonsmanagerapp.Network;

import com.example.mohammed.lessonsmanagerapp.Model.ImdbResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mohammed on 13/01/2017.
 */
//intpoint
public interface ImbdEndpoint {

    String ENDPOINT = "http://imdbapi.poromenos.org/";

    @GET("/js/")
    Call<ImdbResponse> getSeriesByName (@Query("name") String name);


}
