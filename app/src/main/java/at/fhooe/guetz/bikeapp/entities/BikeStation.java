package at.fhooe.guetz.bikeapp.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Entity representing a bike station
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


  public int getEmptySlots() {
    return emptySlots;
  }

  public String getName() {
    return name;
  }

  public int getFreeBikes() {
    return freeBikes;
  }

  @Override
  public String toString() {
    return name + " has " + freeBikes + " free bikes and " + emptySlots + " empty slots.";
  }
}
