package at.fhooe.guetz.bikeapp.model;

import java.util.ArrayList;
import java.util.List;

import at.fhooe.guetz.bikeapp.callbacks.LoadBikeStationsCallback;
import at.fhooe.guetz.bikeapp.entities.BikeNetwork;
import at.fhooe.guetz.bikeapp.entities.BikeStation;
import at.fhooe.guetz.bikeapp.entities.Error;
import at.fhooe.guetz.bikeapp.entities.NetworkApiContainer;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Singleton to load and manage data
 */
public enum DataLoader {
  INSTANCE;

  public static final String NETWORK_ID = "citybike-wien";
  private CityBikesWebservice webService;
  private List<BikeStation> stations;

  public void init() {
    if (isInitialized()) return;
    Retrofit retrofit = new Retrofit.Builder().
        baseUrl("https://api.citybik.es/v2/").
        addConverterFactory(GsonConverterFactory.create()).
        build();
    webService = retrofit.create(CityBikesWebservice.class);
    stations = new ArrayList<>();
  }

  public boolean isInitialized() {
    return webService != null && stations != null;
  }


  public void loadBikes(final LoadBikeStationsCallback callback) {
    if (!isInitialized()){
      //Should not happen
      return;
    }

    webService.getBikeNetwork(NETWORK_ID).enqueue(new Callback<NetworkApiContainer>() {
      @Override
      public void onResponse(Response<NetworkApiContainer> response, Retrofit retrofit) {
        if (response.isSuccess()) {
          NetworkApiContainer bikeNetwork = response.body();
          BikeNetwork network = bikeNetwork.getNetwork();
          if (network != null) {
            stations = network.getStations();
            if (stations == null) stations = new ArrayList<>();
            callback.bikesLoaded(stations, null);
          } else {
            callback.bikesLoaded(stations, Error.GENERAL);
          }
        } else {
          callback.bikesLoaded(stations, Error.GENERAL);
        }
      }

      @Override
      public void onFailure(Throwable t) {
        callback.bikesLoaded(stations, Error.GENERAL);
      }
    });
  }
}
