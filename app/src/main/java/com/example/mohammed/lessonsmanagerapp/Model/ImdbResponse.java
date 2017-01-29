package com.example.mohammed.lessonsmanagerapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohammed on 13/01/2017.
 */

public class ImdbResponse {
    public InnerResponse getResponse() {
        return response;
    }

    @SerializedName("How I Met Your Mother") private InnerResponse response;
}
