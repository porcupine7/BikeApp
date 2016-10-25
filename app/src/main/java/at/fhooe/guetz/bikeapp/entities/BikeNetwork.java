package at.fhooe.guetz.bikeapp.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andy on 25.10.16.
 */

public class BikeNetwork {
  private String id;

  private String name;

  private List<BikeStation> stations;


  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<BikeStation> getStations() {
    return stations;
  }

  @Override
  public String toString() {
    String stationString = getStations() == null ? " no Stations.." : getStations().size() + " stations";
    return getId() + ": " + getName() + " has " + stationString;
  }
}
