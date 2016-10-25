package at.fhooe.guetz.bikeapp.model;

import android.widget.Toast;

import at.fhooe.guetz.bikeapp.callbacks.LoadBikeNetworkCallback;
import at.fhooe.guetz.bikeapp.entities.BikeNetwork;
import at.fhooe.guetz.bikeapp.entities.NetworkApiContainer;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by andy on 25.10.16.
 */

public enum DataManager {
  INSTANCE;

  private CityBikesWebservice webService;

  public void init() {
    if (isInitialized()) return;
    Retrofit retrofit = new Retrofit.Builder().
        baseUrl("https://api.citybik.es/v2/").
        addConverterFactory(GsonConverterFactory.create()).
        build();
    webService = retrofit.create(CityBikesWebservice.class);
  }

  public boolean isInitialized() {
    return webService != null;
  }


  public void loadBikes(final LoadBikeNetworkCallback callback) {
    webService.getBikeNetwork().enqueue(new Callback<NetworkApiContainer>() {
      @Override
      public void onResponse(Response<NetworkApiContainer> response, Retrofit retrofit) {
        if (response.isSuccess()) {
          NetworkApiContainer bikeNetwork = response.body();
          BikeNetwork network = bikeNetwork.getNetwork();
          if (network != null) {
            callback.bikesLoaded(network);
          } else {
            callback.errorLoading("Sorry");
          }
        } else {
          callback.errorLoading("Sorry");
        }
      }

      @Override
      public void onFailure(Throwable t) {
        callback.errorLoading("Sorry, really!");
      }
    });
  }
}
