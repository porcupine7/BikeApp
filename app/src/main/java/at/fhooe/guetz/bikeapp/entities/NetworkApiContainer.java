package at.fhooe.guetz.bikeapp.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Class represents format of API's response
 */
public class NetworkApiContainer {
  @SerializedName("network")
  private BikeNetwork network;

  public BikeNetwork getNetwork() {
    return network;
  }
}
