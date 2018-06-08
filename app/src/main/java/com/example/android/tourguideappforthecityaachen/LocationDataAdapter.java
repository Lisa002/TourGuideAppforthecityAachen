package com.example.android.tourguideappforthecityaachen;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jaina on 20.04.2018.
 */

public class LocationDataAdapter extends ArrayAdapter<LocationData> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    public LocationDataAdapter(Activity context, ArrayList<LocationData> locationdata, int colorResourceId) {

        super(context, 0, locationdata);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }
        // get the current locationData from the ArrayList
        LocationData currentLocationData = getItem(position);

        // finds the name_text_view  layout xml file to set the name of the location
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // sets the Text in the Textview with the current name of the Location from the Arraylist
        nameTextView.setText(currentLocationData.getnameOfLocation());

        // finds the address_text_view  layout xml file to set the address of the location
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        // sets the Text in the Textview with the current address for the location from the Arraylist
        addressTextView.setText(currentLocationData.getaddressOfLocation());

        // finds the picture_image_view  layout xml file to set the the image of the location
        ImageView pictureImageView = (ImageView) listItemView.findViewById(R.id.picture_image_view);
        // sets the the right Picture from the arraylist to the picture image view
        pictureImageView.setImageResource(currentLocationData.getpictureResourcID());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // returns the listItemView with the Data from the Arraylist and the 2 textview, 1 imageview
        return listItemView;
    }
}
