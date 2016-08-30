package ca.ubc.cs.cpsc210.meetup.util;

import org.osmdroid.util.GeoPoint;

import java.util.List;
import java.util.SortedSet;

import ca.ubc.cs.cpsc210.meetup.model.Section;

/**
 * Represents all information needed to plot a route for a schedule.
 * Only exists to separate and abstract the Android UI
 */
public class SchedulePlot {

    // The sections in the schedule
    private SortedSet<Section> sections;
    // The colour to use in hex
    private String colourOfLine;
    // The route between the sections
    private List<GeoPoint> route;
    // The icon to use as R.drawable...
    private int iconToUseForBuilding;
    // Who is this schedule for
    private String name;
    // Check to see if only two sections and in same building
    private boolean same = false;
    // Check to see if only one section
    private boolean onlyOne = false;

    /**
     * Constructor
     * @param sections The sections in the schedule, non-null
     * @param name The name of whose schedule this is
     * @param colourOfLine The colour to use
     * @param iconToUseForBuilding The icon for the building
     */
    public SchedulePlot(SortedSet<Section> sections, String name, String colourOfLine, int iconToUseForBuilding) {
        this.sections = sections;
        this.colourOfLine = colourOfLine;
        this.iconToUseForBuilding = iconToUseForBuilding;
        this.name = name;
    }

    public SortedSet<Section> getSections() {
        return sections;
    }

    public String getColourOfLine() {
        return colourOfLine;
    }

    public void setRoute(List<GeoPoint> route) {
        this.route = route;
    }

    public List<GeoPoint> getRoute() {
        return route;
    }

    public int getIcon() { return iconToUseForBuilding; }

    public String getName() { return name; }

    public boolean getSame() { return same; }

    public void setSame(boolean same) { this.same = same; }

    public boolean getOnlyOne() { return onlyOne; }

    public void setOnlyOne(boolean onlyOne) { this.onlyOne = onlyOne; }
}
