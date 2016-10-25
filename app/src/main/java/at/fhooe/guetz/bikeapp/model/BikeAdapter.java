package at.fhooe.guetz.bikeapp.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import java.util.List;

import at.fhooe.guetz.bikeapp.R;
import at.fhooe.guetz.bikeapp.entities.BikeStation;

/**
 * Created by andy on 25.10.16.
 */

public class BikeAdapter extends RecyclerView.Adapter<BikeAdapter.ViewHolder> {

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView freeBikes;
    public TextView emptySlots;

    public ViewHolder(View itemView) {
      super(itemView);
      this.name = (TextView) itemView.findViewById(R.id.txt_bike_name);
      this.freeBikes = (TextView) itemView.findViewById(R.id.txt_bike_free);
      this.emptySlots = (TextView) itemView.findViewById(R.id.txt_bike_slots);
    }
  }

  private final List<BikeStation> bikeStations;

  public BikeAdapter(@NonNull List<BikeStation> bikeStations) {
    this.bikeStations = bikeStations;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item_bike, parent, false);

    return new ViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    BikeStation curStation = bikeStations.get(position);
    holder.name.setText(curStation.getName());
    holder.freeBikes.setText(String.format("%d", curStation.getFreeBikes()));
    holder.emptySlots.setText(String.format("%d", curStation.getEmptySlots()));
  }

  @Override
  public int getItemCount() {
    return bikeStations.size();
  }
}
