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
import com.google.android.gms.maps.model.*;


public class MainActivity extends FragmentActivity implements RouteCoordonates {

    public static GoogleMap map;
    public static int red = Color.argb(255, 255, 0, 0);
    public static int blue = Color.argb(255, 0, 0, 255);


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

    public void addRoutesToArrayList() {


        routesOf104.add(CimitirSfLazar);
        routesOf104.add(Micro17);
        routesOf104.add(Oltului);
        routesOf104.add(Tiglina1);
        routesOf104.add(Banci);
        routesOf104.add(Mazepa);
        routesOf104.add(Potcoava);
        routesOf104.add(ParcEminescu);
        routesOf104.add(Universitate);
        routesOf104.add(ParfumulTeilor);
        routesOf104.add(Basarabiei);
        routesOf104.add(BlocIalomita);
        routesOf104.add(CamineStudentesti);
        routesOf104.add(CaminulDeBatrani);
        routesOf104.add(ParcCFR);


    }

    public void addMarkersAndPolylines() {

        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(red)
                       .width(6)
                       .geodesic(true) ;
//
//        map.addPolyline(new PolylineOptions().geodesic(true)
//                .add(new LatLng(-33.866, 151.195))  // Sydney
//                .add(new LatLng(-18.142, 178.431))  // Fiji
//                .add(new LatLng(21.291, -157.821))  // Hawaii
//                .add(new LatLng(37.423, -122.091))  // Mountain View
//        );

        //TODO atentie polylines trebuie setate mai bine ( arata ca taie direct prin rondou )
        for (Route r : routesOf104)     {

            polylineOptions.add(r.getLatLng());
            System.out.println("Added the " + r.getName() + "route.");


            map.addMarker(new MarkerOptions()
                    .title(r.getName())
                    .snippet("104")
                    .position(r.getLatLng())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_icon)));




           }

        map.addPolyline(polylineOptions);





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        System.out.println("My screen type is " + getApplicationContext().getResources().getDisplayMetrics().density);

        map = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();


        map.setMyLocationEnabled(true);
        map.getUiSettings().setCompassEnabled(true);

        LatLng currentLocation = getCurrentLocation();
        System.out.println("mtn current location: " + currentLocation);
        System.out.println("mtn distance: " + distFrom(currentLocation, Tiglina1.getLatLng()));



        map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 13));

        addRoutesToArrayList();
        addMarkersAndPolylines();









    }


}