package at.fhooe.guetz.bikeapp.model;

import at.fhooe.guetz.bikeapp.entities.BikeNetwork;
import at.fhooe.guetz.bikeapp.entities.NetworkApiContainer;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by andy on 25.10.16.
 */
public interface CityBikesWebservice {

  @GET("networks/citybike-wien")
  Call<NetworkApiContainer> getBikeNetwork();
}
