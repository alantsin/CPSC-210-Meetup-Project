package ca.ubc.cs.cpsc210.meetup.model;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.osmdroid.util.GeoPoint;

/**
 * Created by Alan on 4/4/2015.
 */
public class MeetUpParser {

    StudentManager manager = new StudentManager();
    String firstName = null;
    int id;
    String lastName = null;

    public Student parse(String input) {
        JSONTokener token = new JSONTokener(input);
        try {
            JSONObject obj = new JSONObject(token);
            firstName = obj.getString("FirstName");
            id = obj.getInt("Id");
            lastName = obj.getString("LastName");
            manager.addStudent(lastName, firstName, id);
            JSONArray arr = obj.getJSONArray("Sections");
            for (int i = 0; i < arr.length(); i++) {
                String courseName = arr.getJSONObject(i).getString("CourseName");
                int courseNumber = arr.getJSONObject(i).getInt("CourseNumber");
                String sectionName = arr.getJSONObject(i).getString("SectionName");
                manager.addSectionToSchedule(id, courseName, courseNumber, sectionName);
            }
        } catch (JSONException j) {
            j.printStackTrace();
        }
        return manager.get(id);
    }

}
