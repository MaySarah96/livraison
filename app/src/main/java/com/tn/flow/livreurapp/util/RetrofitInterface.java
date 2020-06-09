package com.tn.flow.livreurapp.util;


import com.google.gson.JsonObject;
import com.tn.flow.livreurapp.model.Livraison;
import com.tn.flow.livreurapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @POST("/authenticate/{username}/{mdp}/true")
    public Call<User> Login(@Path("username") String username,@Path("mdp") String mdp);

     @POST("/afficherleslivraison/{userId}")
    public Call<List<Livraison>> getLivraison(@Path("userId") String userId);







}
