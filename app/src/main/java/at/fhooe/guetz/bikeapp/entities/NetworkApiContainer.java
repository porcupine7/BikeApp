package at.fhooe.guetz.bikeapp.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andy on 25.10.16.
 */

public class NetworkApiContainer {

  @SerializedName("network")
  private BikeNetwork network;

  public BikeNetwork getNetwork() {
    return network;
  }
}
