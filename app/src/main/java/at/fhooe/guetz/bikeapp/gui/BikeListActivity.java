package at.fhooe.guetz.bikeapp.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import at.fhooe.guetz.bikeapp.R;
import at.fhooe.guetz.bikeapp.entities.BikeNetwork;
import at.fhooe.guetz.bikeapp.entities.NetworkApiContainer;
import at.fhooe.guetz.bikeapp.model.CityBikesWebservice;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class BikeListActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bike_list);
    Retrofit retrofit = new Retrofit.Builder().
        baseUrl("https://api.citybik.es/v2/").
        addConverterFactory(GsonConverterFactory.create()).
        build();
    CityBikesWebservice webService = retrofit.create(CityBikesWebservice.class);
    webService.getBikeNetwork().enqueue(new Callback<NetworkApiContainer>() {
      @Override
      public void onResponse(Response<NetworkApiContainer> response, Retrofit retrofit) {
        if (response.isSuccess()) {
          NetworkApiContainer bikeNetwork = response.body();
          BikeNetwork network = bikeNetwork.getNetwork();
          if (network != null)
            Toast.makeText(getApplicationContext(), network.toString(), Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(getApplicationContext(), "Sorry, something went wrong!", Toast.LENGTH_SHORT).show();
        }
      }

      @Override
      public void onFailure(Throwable t) {
        Toast.makeText(getApplicationContext(), "Sorry, something went really wrong!", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
