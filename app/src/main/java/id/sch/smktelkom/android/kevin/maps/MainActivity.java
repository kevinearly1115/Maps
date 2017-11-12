package id.sch.smktelkom.android.kevin.maps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {



    static final CameraPosition INDONESIA = CameraPosition.builder()

            .target(new LatLng(-6.175392, 106.827178))

            .zoom(15)

            .bearing(0)

            .tilt(45)

            .build();



    GoogleMap m_map;

    boolean mapReady = false;

    LatLng IND = new LatLng(-6.175392, 106.827178);

    LatLng FRC = new LatLng(48.858270, 2.294509);

    LatLng USA = new LatLng(38.897678, -77.036477);

    LatLng AUS = new LatLng(-33.856820, 151.215279);

    MarkerOptions Indonesia, France, UnitedState, Australia;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        Indonesia = new MarkerOptions()

                .position(new LatLng(-6.175392, 106.827178))

                .title("Monumen Nasional")

                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.us));



        France = new MarkerOptions()

                .position(new LatLng(48.858270, 2.294509))

                .title("Eiffel Tower")

                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.us));



        UnitedState = new MarkerOptions()

                .position(new LatLng(38.897678, -77.036477))

                .title("The White House")

                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.us));



        Australia = new MarkerOptions()

                .position(new LatLng(-33.856820, 151.215279))

                .title("Sydney Opera House")

                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.us));



        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }



    private void flyTo(CameraPosition target) {

        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);

    }



    @Override

    public void onMapReady(GoogleMap map) {

        mapReady = true;

        m_map = map;

        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(INDONESIA));

        map.addCircle(new CircleOptions()

                .center(IND)

                .radius(500)

                .strokeColor(Color.GREEN)

                .fillColor(Color.argb(64, 0, 255, 0)));

        m_map.addMarker(Indonesia);

        m_map.addMarker(France);

        m_map.addMarker(UnitedState);

        m_map.addMarker(Australia);

    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {

            return true;

        }

        return super.onOptionsItemSelected(item);

    }

}