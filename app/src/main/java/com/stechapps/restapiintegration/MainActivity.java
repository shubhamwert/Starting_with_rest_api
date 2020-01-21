package com.stechapps.restapiintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String Base_Url="http://192.168.43.219:5000";
    private static Retrofit retrofit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void connectAndGetApiData(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create()).build();

        }
        PredictApi predictApi=retrofit.create(PredictApi.class);
        JsonObject j=new JsonObject();

        try {
            EditText p = findViewById(R.id.ED1);

            String a= p.getText().toString();
            j.addProperty("data",a);
        }catch (Exception e){
            Log.e("ERRRRRRRRRRRRRRORRRRRRRRRRRRRRR", "connectAndGetApiData: "+e );
        }
        Call<Ressponse> call=predictApi.Predict(j);

        call.enqueue(new Callback<Ressponse>() {
            @Override
            public void onResponse(Call<Ressponse> call, Response<Ressponse> response) {
                if(response.isSuccessful()){
                TextView tv=findViewById(R.id.tv1);
                Toast.makeText(MainActivity.this,""+response.body().getPredict(),Toast.LENGTH_SHORT).show();
                tv.setText(String.format("%s", response.body().getPredict()));
            }}

            @Override
            public void onFailure(Call<Ressponse> call, Throwable t) {
                Log.e("HEEEEEEEEREEEEEEEEEEE", t.toString());
            }
        });
    }


    public void send(View view) {
        connectAndGetApiData();
    }
}
