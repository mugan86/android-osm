package amuxika.androidopenstreetmap;

/**
 * Created by anartzmugika on 19/4/16.
 */

import org.osmdroid.util.GeoPoint;

/**********************************************
 * Created by anartzmugika on 26/2/16.
 **********************************************/


public class MyItem {
    private final GeoPoint mPosition;

    public MyItem(double lat, double lng) {
        mPosition = new GeoPoint(lat, lng);
    }

    public GeoPoint getPosition() {
        return mPosition;
    }
}
