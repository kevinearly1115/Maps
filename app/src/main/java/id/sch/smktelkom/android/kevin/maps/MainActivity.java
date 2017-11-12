package id.sch.smktelkom.android.kevin.maps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady = false;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Button bMap = (Button) findViewById(R.id.bMap);

        bMap.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (mapReady)

                    m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            }

        });


        Button bSatelite = (Button) findViewById(R.id.bSatelite);

        bSatelite.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (mapReady)

                    m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

            }

        });


        Button bHybrid = (Button) findViewById(R.id.bHybrid);

        bHybrid.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (mapReady)

                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

            }

        });


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }


    @Override

    public void onMapReady(GoogleMap map) {

        mapReady = true;

        m_map = map;

        LatLng Gumul = new LatLng(-7.815822, 112.0600773);

        CameraPosition target = CameraPosition.builder().target(Gumul).zoom(14).build();

        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));

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