package at.fhooe.guetz.bikeapp.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import at.fhooe.guetz.bikeapp.R;
import at.fhooe.guetz.bikeapp.callbacks.LoadBikeNetworkCallback;
import at.fhooe.guetz.bikeapp.entities.BikeNetwork;
import at.fhooe.guetz.bikeapp.entities.NetworkApiContainer;
import at.fhooe.guetz.bikeapp.model.CityBikesWebservice;
import at.fhooe.guetz.bikeapp.model.DataManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class BikeListActivity extends AppCompatActivity implements LoadBikeNetworkCallback {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bike_list);
    DataManager.INSTANCE.init();
    DataManager.INSTANCE.loadBikes(this);
  }

  @Override
  public void bikesLoaded(BikeNetwork bikeNetwork) {
    BikeListFragment listFragment = new BikeListFragment();
    listFragment.setBikeStations(bikeNetwork.getStations());
    getFragmentManager().beginTransaction().replace(R.id.content, listFragment).commit();
  }

  @Override
  public void errorLoading(String errorMsg) {

  }
}
