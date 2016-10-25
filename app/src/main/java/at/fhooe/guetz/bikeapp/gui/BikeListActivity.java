package at.fhooe.guetz.bikeapp.gui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import at.fhooe.guetz.bikeapp.R;
import at.fhooe.guetz.bikeapp.callbacks.LoadBikeStationsCallback;
import at.fhooe.guetz.bikeapp.entities.BikeStation;
import at.fhooe.guetz.bikeapp.model.DataLoader;
import at.fhooe.guetz.bikeapp.entities.Error;

/**
 * Main activity loads data and instantiates the fragment
 */
public class BikeListActivity extends AppCompatActivity implements LoadBikeStationsCallback {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bike_list);
    DataLoader.INSTANCE.init();
    DataLoader.INSTANCE.loadBikes(this);
  }


  @Override
  public void bikesLoaded(@NonNull List<BikeStation> bikeStations, @Nullable Error error) {
    BikeListFragment listFragment = new BikeListFragment();
    listFragment.setBikeStations(bikeStations);
    getFragmentManager().beginTransaction().replace(R.id.content, listFragment).commit();

    if (error != null) {
      Toast.makeText(getApplicationContext(), getString(error.getErrorMsg()), Toast.LENGTH_SHORT).show();
    }

  }
}
