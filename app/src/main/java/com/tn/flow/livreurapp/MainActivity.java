package com.tn.flow.livreurapp;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.tn.flow.livreurapp.model.User;
import com.tn.flow.livreurapp.util.ApiUtil;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();
    ImageButton LoginButton;
    TextInputEditText nomTv,mdptv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton = findViewById(R.id.LoginButton);
        nomTv = findViewById(R.id.login);
        mdptv = findViewById(R.id.mdp);
        LoginButton.setOnClickListener(v -> {
            if (TextUtils.isEmpty(nomTv.getText()) || TextUtils.isEmpty(mdptv.getText())) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }
           ApiUtil.getServiceClass().Login(nomTv.getText().toString(),mdptv.getText().toString()).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Log.e(TAG, "onResponse: "+response.body().getNom());
                    Log.e(TAG, "onResponse: "+response.body().getUserName());
                    Log.e(TAG, "onResponse: "+response.body().getUserId());
                    savePrefsData(response.body().getUserId().toString(),response.body().getNom(),response.body().getPrenom(),response.body().getCin().toString(),response.body().getNumTel().toString());
                     startActivity(new Intent(MainActivity.this,ChangeEtatActivity.class));
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
            //Log.e(TAG, "onResponse: "+nomTv.getText().toString());
           // Log.e(TAG, "onResponse: "+mdptv.getText().toString());
           // startActivity(new Intent(MainActivity.this,ChangeEtatActivity.class));
            //savePrefsData("test","may sarah","ameur","09624446","55307666");
        });
    }


    private void savePrefsData(String id,String nom,String prenom,String cin,String telephonr) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.putString("userId",id);
        editor.putString("nom",nom);
        editor.putString("prenom",prenom);
        editor.putString("cin",cin);
        editor.putString("telephone",telephonr);
        editor.apply();


    }
}
