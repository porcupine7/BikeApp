package at.fhooe.guetz.bikeapp.callbacks;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import at.fhooe.guetz.bikeapp.entities.BikeStation;
import at.fhooe.guetz.bikeapp.entities.Error;

/**
 * Callback for GUI classes when loading model classes
 */
public interface LoadBikeStationsCallback {

  /**
   * @param bikeStations list of BikeStations, loaded from network. when error!=null, could be not recent or empty
   * @param error        is null when everything's ok
   */
  void bikesLoaded(@NonNull List<BikeStation> bikeStations, @Nullable Error error);
}
