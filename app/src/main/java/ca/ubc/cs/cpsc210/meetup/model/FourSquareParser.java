package ca.ubc.cs.cpsc210.meetup.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import ca.ubc.cs.cpsc210.meetup.model.EatingPlace;
import ca.ubc.cs.cpsc210.meetup.model.Place;
import ca.ubc.cs.cpsc210.meetup.model.PlaceFactory;
import ca.ubc.cs.cpsc210.meetup.util.LatLon;

/**
 * Created by Alan on 4/5/2015.
 */
public class FourSquareParser {

    String name;
    Double lat;
    Double lng;
    LatLon latLon;
    PlaceFactory places;
    int length;
    FourSquareParserData data;

    public FourSquareParserData parse(String input) {
        places = PlaceFactory.getInstance();
        JSONTokener token = new JSONTokener(input);
        try {
            JSONObject obj = new JSONObject(token);
            JSONArray arr = obj.getJSONObject("response").getJSONArray("groups").getJSONObject(0).getJSONArray("items");
            for (int i = 0; i < arr.length(); i++) {
                name = arr.getJSONObject(i).getJSONObject("venue").getString("name");
                lat = Double.parseDouble(arr.getJSONObject(i).getJSONObject("venue").getJSONObject("location").getString("lat"));
                lng = Double.parseDouble(arr.getJSONObject(i).getJSONObject("venue").getJSONObject("location").getString("lng"));
                latLon = new LatLon(lat, lng);
                places.add(new EatingPlace(name, latLon));
            }
            length = arr.length();
        } catch (JSONException j) {
            j.printStackTrace();
        }
        data = new FourSquareParserData(places, length);
        return data;
    }
}
