package com.example.android.tourguideappforthecityaachen;

import android.net.Uri;


/**
 * Created by Jaina on 20.04.2018.
 */

public class LocationData {

    int mpictureResourceId;
    int mnameOfLocation;
    int maddressOfLocation;
    Uri muriLocation;

    /**
     * Create a new LocationData object
     *
     * @param nameOfLocation    contains the name of the location
     * @param addressOfLocation contains the address of the location
     * @param pictureResourceID contain the ID of the picture that belongs to the location
     */
    public LocationData(int nameOfLocation, int addressOfLocation, int pictureResourceID, Uri uriLocation) {
        mnameOfLocation = nameOfLocation;
        maddressOfLocation = addressOfLocation;
        mpictureResourceId = pictureResourceID;
        muriLocation = uriLocation;
    }

    public int getnameOfLocation() {
        return mnameOfLocation;
    }

    public int getaddressOfLocation() {
        return maddressOfLocation;

    }

    public int getpictureResourcID() {
        return mpictureResourceId;
    }

    public Uri geturiLocation() {
        return muriLocation;
    }
}

