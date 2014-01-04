package ro.transsist;

import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class MainActivity extends FragmentActivity implements CoordTrasee {

    public static GoogleMap map;
    public static HashMap<LatLng, String> stringHashMap;

    public static float distFrom (LatLng o1, LatLng o2)
    {

        double lat1 = o1.latitude;
        double lng1 = o1.longitude;

        double lat2 = o2.latitude;
        double lng2 = o2.longitude;


        double earthRadius = 3958.75;
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c;

        int meterConversion = 1609;

        return new Float(dist * meterConversion).floatValue();
    }


    public LatLng getCurrentLocation () {

        LocationManager service = (LocationManager)getApplication().getSystemService(getApplication().LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = service.getBestProvider(criteria, false);
        Location location = service.getLastKnownLocation(provider);

        return new LatLng(location.getLatitude(),location.getLongitude());
    }

    public void addTo104 () {

        stringHashMap = new HashMap<LatLng, String>();
        stringHashMap.put(CimitirSfLazar, "CimitirSfLazar");

        a104.add(CimitirSfLazar);
        a104.add(Micro17);
        a104.add(Oltului);
        a104.add(Tiglina1);
        a104.add(Banci);
        a104.add(Mazepa);
        a104.add(Potcoava);
        a104.add(ParcEminescu);
        a104.add(Universitate);
        a104.add(ParfumulTeilor);
        a104.add(Basarabiei);
        a104.add(BlocIalomita);
        a104.add(CamineStudentesti);
        a104.add(CaminulDeBatrani);
        a104.add(ParcCFR);

    }

    public void addMarkers (ArrayList<LatLng> traseu) {

        for (LatLng t : traseu)  {

            map.addMarker(new MarkerOptions()
                    .title(stringHashMap.get(t))
                    .snippet("9 104")
                    .position(t));
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        map = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();


        map.setMyLocationEnabled(true);
        map.getUiSettings().setCompassEnabled(true);

        LatLng currentLocation = getCurrentLocation();
        System.out.println("mtn current location: " + currentLocation);
        System.out.println("mtn distance: " + distFrom(currentLocation, Tiglina1));



        map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));
        addMarkers();


        int red = Color.argb(255, 255, 0, 0);

        addTo104();

        map.addPolyline(new PolylineOptions().color(red).width(5).addAll(a104));





    }


}