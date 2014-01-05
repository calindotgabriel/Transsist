package ro.transsist;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created with IntelliJ IDEA.
 * User: motan
 * Date: 1/5/14
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Route {

    private String name;
    private LatLng coord;

    public Route (String name, double lat, double lng) {

        this.name = name;
        this.coord = new LatLng(lat,lng);
    }

    public String getName() {
        return name;
    }

    public LatLng getLatLng() {
        return coord;
    }
}
