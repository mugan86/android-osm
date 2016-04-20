package amuxika.androidopenstreetmap;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.bonuspack.location.POI;
import org.osmdroid.util.GeoPoint;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anartzmugika on 19/4/16.
 */
public class Utils {



    public static List<MyItem> read(Context context) throws JSONException {

        InputStream inputStream = context.getResources().openRawResource(R.raw.locations);
        List<MyItem> items = read(inputStream);

        return items;
    }

    private static List<MyItem> read(InputStream inputStream) throws JSONException {
        List<MyItem> items = new ArrayList<>();
        String json = new Scanner(inputStream).useDelimiter(REGEX_INPUT_BOUNDARY_BEGINNING).next();
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            double lat = object.getDouble("lat");
            double lng = object.getDouble("lng");
            items.add(new MyItem(lat, lng));
        }
        return items;
    }

    public static List<POI> readPOI(Context context) throws JSONException {

        InputStream inputStream = context.getResources().openRawResource(R.raw.locations);
        List<POI> items = readPOI(inputStream);

        return items;
    }

    private static final String REGEX_INPUT_BOUNDARY_BEGINNING = "\\A";

    private static List<POI> readPOI(InputStream inputStream) throws JSONException {
        List<POI> items = new ArrayList<>();
        String json = new Scanner(inputStream).useDelimiter(REGEX_INPUT_BOUNDARY_BEGINNING).next();
        POI opoi;
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            opoi = new POI(11);

            JSONObject object = array.getJSONObject(i);
            double lat = object.getDouble("lat");
            double lng = object.getDouble("lng");
            opoi.mLocation = new GeoPoint(lat, lng);
            items.add(opoi);
        }
        return items;
    }
}
