package at.fhooe.guetz.bikeapp.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andy on 25.10.16.
 */

public class BikeStation {
  private String name;
  @SerializedName("free_bikes")
  private int freeBikes;
  @SerializedName("empty_slots")
  private int emptySlots;

  private String id;
  private double latitude;
  private double longitude;
  private String timestamp;


  @Override
  public String toString() {
    return name + " has " + freeBikes + " free bikes and " + emptySlots + " empty slots.";
  }
}
