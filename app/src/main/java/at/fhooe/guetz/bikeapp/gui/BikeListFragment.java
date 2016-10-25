package at.fhooe.guetz.bikeapp.gui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import at.fhooe.guetz.bikeapp.R;
import at.fhooe.guetz.bikeapp.entities.BikeStation;
import at.fhooe.guetz.bikeapp.model.BikeAdapter;

/**
 * Created by andy on 25.10.16.
 */
public class BikeListFragment extends Fragment {

  private List<BikeStation> bikeStations;

  public void setBikeStations(@NonNull List<BikeStation> bikeStations) {
    this.bikeStations = bikeStations;
  }

  public List<BikeStation> getBikeStations() {
    return bikeStations;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_bike_list, container, false);
    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_bikes);
    recyclerView.setHasFixedSize(true);
    if (getBikeStations() != null) {
      recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
      BikeAdapter adapter = new BikeAdapter(getBikeStations(), getActivity());
      recyclerView.setAdapter(adapter);
    }
    return rootView;
  }
}
