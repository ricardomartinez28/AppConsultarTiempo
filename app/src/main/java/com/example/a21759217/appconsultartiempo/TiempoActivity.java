package com.example.a21759217.appconsultartiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a21759217.appconsultartiempo.pojo.Weather;
import com.example.a21759217.appconsultartiempo.retrofitUtils.APIRestService;
import com.example.a21759217.appconsultartiempo.retrofitUtils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TiempoActivity extends AppCompatActivity {

    TextView tvZona;
    TextView tvTemperatura;
    TextView tvHora;
    TextView tvValorH;
    TextView tvValorLL;
    TextView tvSumario;
    ImageView ivFoto;
    String latitud;
    String longitud;

    Weather weather;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);

        tvZona=findViewById(R.id.tvZona);
        tvTemperatura=findViewById(R.id.tvTemperatura);
        tvValorH=findViewById(R.id.tvValorHumedad);
        tvHora=findViewById(R.id.tvHora);
        tvValorLL=findViewById(R.id.tvValorLluvia);
        tvSumario=findViewById(R.id.tvSumario);
        ivFoto=findViewById(R.id.ivFoto);

        latitud=getIntent().getStringExtra("LATITUD");
        longitud=getIntent().getStringExtra("LONGITUD");

        cargarDatos();

    }

    private void cargarDatos() {
        Retrofit r = RetrofitClient.getClient(APIRestService.BASE_URL);
        APIRestService ars = r.create(APIRestService.class);
        Call<Weather> call = ars.obtenerTiempo(APIRestService.KEY, latitud,longitud,APIRestService.EXCLUDE,APIRestService.LANG);

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(!response.isSuccessful()){
                    Log.i("Resultado","Error"+response.code());

                }else{
                    weather=response.body();

                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });


    }


}
