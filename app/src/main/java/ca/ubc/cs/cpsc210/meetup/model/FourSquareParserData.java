package ca.ubc.cs.cpsc210.meetup.model;

/**
 * Created by Alan on 4/6/2015.
 */
public class FourSquareParserData {

    PlaceFactory pFactory;
    int size;

    public FourSquareParserData(PlaceFactory pFactory, int size) {
        this.pFactory = pFactory;
        this.size = size;
    }

    public PlaceFactory getPFactory() {
        return pFactory;
    }

    public int getSize() {
        return size;
    }
}
