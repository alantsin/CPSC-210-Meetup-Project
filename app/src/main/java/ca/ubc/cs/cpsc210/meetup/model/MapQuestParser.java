package ca.ubc.cs.cpsc210.meetup.model;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.osmdroid.util.GeoPoint;

/**
 * Created by Alan on 4/3/2015.
 */
public class MapQuestParser {

    Double lat;
    Double lng;
    GeoPoint geoPoint;
    List<GeoPoint> geoPoints = new LinkedList<GeoPoint>();

    public List<GeoPoint> parse(String input) {
        JSONTokener token = new JSONTokener(input);
        try {
            JSONObject obj = new JSONObject(token);
            obj = obj.getJSONObject("route").getJSONObject("shape");
            JSONArray arr = obj.getJSONArray("shapePoints");
            for (int i = 0; i < arr.length(); i++) {
                if (i % 2 == 0) {
                    lat = arr.getDouble(i);
                } else {
                    lng = arr.getDouble(i);
                    geoPoint = new GeoPoint(lat, lng);
                    geoPoints.add(geoPoint);
                }
            }
        } catch (JSONException j) {
            j.printStackTrace();
        }
        return geoPoints;
    }

}