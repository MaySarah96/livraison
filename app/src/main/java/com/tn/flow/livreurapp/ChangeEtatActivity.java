package com.tn.flow.livreurapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.tn.flow.livreurapp.model.Livraison;
import com.tn.flow.livreurapp.util.ApiUtil;

import java.util.List;

public class ChangeEtatActivity extends AppCompatActivity {

    String TAG = ChangeEtatActivity.class.getSimpleName();
    Button Logout,button2;
    TextView textView9,textView10,textView12,textView4,textView13,textView15;
    String idL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        String id = pref.getString("userId","1");
        String nom = pref.getString("nom","1");
        String prenom = pref.getString("prenom","1");
        String cin = pref.getString("cin","1");
        String telephone = pref.getString("telephone","1");

        setContentView(R.layout.activity_change_etat);
        Logout = findViewById(R.id.Logout);
        button2 = findViewById(R.id.button2);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView12 = findViewById(R.id.textView12);
        textView9.setText(String.format("%s %s", nom, prenom));
        textView9.setText(cin);
        textView9.setText(telephone);
        ApiUtil.getServiceClass().getLivraison(id).enqueue(new Callback<List<Livraison>>() {
            @Override
            public void onResponse(Call<List<Livraison>> call, Response<List<Livraison>> response) {
                Log.e(TAG, "onResponse: "+response.body().get(0).getIdLivra().toString());
                textView4.setText(String.format("%sDnt", response.body().get(0).getFraisLivra().toString()));
                textView13.setText(response.body().get(0).getDestLivra());
                textView4.setText(response.body().get(0).getEtatLivra());
                textView15.setText(response.body().get(0).getEtatLivra());
                idL = response.body().get(0).getIdLivra().toString();
            }

            @Override
            public void onFailure(Call<List<Livraison>> call, Throwable t) {

            }
        });
        Logout.setOnClickListener(v -> {
            // Clear preferences
            SharedPreferences.Editor editor = pref.edit();
            editor.remove("isIntroOpnend");
            editor.apply();
            startActivity(new Intent(ChangeEtatActivity.this,MainActivity.class));

        });
        button2.setOnClickListener(v -> {
            ApiUtil.getServiceClass().mettreajour(id,idL,"livrer");
        });
    }


}
