package at.fhooe.guetz.bikeapp.callbacks;

import at.fhooe.guetz.bikeapp.entities.BikeNetwork;

/**
 * Created by andy on 25.10.16.
 */
public interface LoadBikeNetworkCallback {

  void bikesLoaded(BikeNetwork bikeNetwork);

  void errorLoading(String errorMsg);
}
