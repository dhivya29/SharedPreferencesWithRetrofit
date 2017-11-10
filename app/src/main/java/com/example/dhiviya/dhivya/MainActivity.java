package com.example.dhiviya.dhivya;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import com.example.dhiviya.dhivya.preference.PreferenceKeys;
import com.example.dhiviya.dhivya.preference.PreferencesPiczy;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView txtSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSplash = (TextView) findViewById(R.id.txtSplash);
        String checkPreference = PreferencesPiczy.getStringValue(getApplicationContext(), PreferenceKeys.Images + "0");
        if (checkPreference.equals("")) {
            loadData();
        } else {
            Toast.makeText(getApplicationContext(), "Already Loaded", Toast.LENGTH_LONG).show();
            callTabActivity();
        }
    }


    private void loadData() {
        Toast.makeText(getApplicationContext(), "Loading Data So please Wait..", Toast.LENGTH_SHORT).show();
        ApiService api = RetroClient.getApiService();
        Call<Json> call = api.getMyJSON();
        call.enqueue(new Callback<Json>() {
            @Override
            public void onResponse(Call<Json> call, Response<Json> response) {
                String respon = response.body().toString();
                if (respon != null) {
                    Json weatherList = response.body();
                    for (int i = 0; i < weatherList.Item.Content.size(); i++) {
                        PreferencesPiczy.setStringValue(getApplicationContext(), PreferenceKeys.Images + i, weatherList.Item.Content.get(i).URL);
                    }
                    callTabActivity();
                }
            }

            @Override
            public void onFailure(Call<Json> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Network Connection Is Not Available", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void callTabActivity() {
        txtSplash.setVisibility(View.GONE);
        TabActivity tabActivity = new TabActivity();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frmBase, tabActivity).commit();
    }

}

