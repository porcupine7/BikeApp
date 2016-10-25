package at.fhooe.guetz.bikeapp.model;

import at.fhooe.guetz.bikeapp.entities.NetworkApiContainer;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Retrofit API methods
 */
interface CityBikesWebservice {

  @GET("networks/{network_id}")
  Call<NetworkApiContainer> getBikeNetwork(@Path("network_id") String networkId);
}
