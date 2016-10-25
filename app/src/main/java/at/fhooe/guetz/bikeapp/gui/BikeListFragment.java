package at.fhooe.guetz.bikeapp.gui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.fhooe.guetz.bikeapp.R;

/**
 * Created by andy on 25.10.16.
 */

public class BikeListFragment extends Fragment {


  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_bike_list, container, false);

    return rootView;
  }
}
