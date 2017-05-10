package edu.ma.wa.nqueue.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import edu.ma.wa.nqueue.retrofitexample.Location;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://thawing-tundra-28436.herokuapp.com/services/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Create an instance of GoogleAPIClient.


        MyApiEndpointInterface apiService =
                retrofit.create(MyApiEndpointInterface.class);

        Call<ResponseBody> call2 = apiService.updateLocation(new Location("zack",1,1));
        call2.enqueue(new Callback<ResponseBody>() {
            @Override

            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                TextView t = (TextView)findViewById(R.id.textbox);
                int statusCode = response.code();
                ResponseBody user = response.body();
                try {
                    t.setText(user.string());
                }catch(Exception e){

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // Log error here since request failed
            }
        });


        Call<ResponseBody> call = apiService.getLoc("all");
        call.enqueue(new Callback<ResponseBody>() {
            @Override

            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                TextView t = (TextView)findViewById(R.id.textbox);
                int statusCode = response.code();
                ResponseBody user = response.body();
                try {
                    t.setText(user.string());
                }catch(Exception e){

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // Log error here since request failed
            }
        });



    }


}
