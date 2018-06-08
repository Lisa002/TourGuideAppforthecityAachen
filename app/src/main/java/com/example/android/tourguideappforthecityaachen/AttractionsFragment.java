package com.example.android.tourguideappforthecityaachen;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.information_list, container, false);


        //Creates an arraylist to store the information about the attractions
        final ArrayList<LocationData> locations = new ArrayList<LocationData>();
        locations.add(new LocationData(R.string.attraction_aachener_dom, R.string.attraction_address_aachener_adom, R.drawable.dom_aachen,
                Uri.parse("https://www.google.de/maps/place/Aachener+Dom,+52062+Aachen/@50.7747515,6.0818093,634m/data=!3m1!1e3!4m13!1m7!3m6!1s0x47c0997cba2b0ed5:0xa0e95a0314accaf3!2sAachener+Dom,+52062+Aachen!3b1!8m2!3d50.774723!4d6.0839203!3m4!1s0x47c0997cba2b0ed5:0xa0e95a0314accaf3!8m2!3d50.774723!4d6.0839203")));
        locations.add(new LocationData(R.string.attraction_elisenbrunnen, R.string.attraction_address_elisenbrunnen, R.drawable.elisenbrunnen,
                Uri.parse("https://www.google.de/maps/place/Elisenbrunnen/@50.7741453,6.086872,15z/data=!4m5!3m4!1s0x0:0x8eb3785ac7865d2e!8m2!3d50.7741453!4d6.086872")));
        locations.add(new LocationData(R.string.attraction_ponttor, R.string.attraction_address_ponttor, R.drawable.ponttor,
                Uri.parse("https://www.google.de/maps/place/Ponttor/@50.7816068,6.0782484,15z/data=!4m2!3m1!1s0x0:0x5701a4017f4764c5?sa=X&ved=0ahUKEwiByqqv2tLaAhXFFSwKHSL6D6cQ_BIIugEwCg")));
        locations.add(new LocationData(R.string.attraction_marschiertor, R.string.attraction_address_marschiertor, R.drawable.marschiertor,
                Uri.parse("https://www.google.de/maps/place/Marschiertor/@50.7681726,6.0846405,17z/data=!3m1!4b1!4m5!3m4!1s0x47c09bd8f902daf5:0x9255ad9d4629834b!8m2!3d50.7681692!4d6.0868292")));
        locations.add(new LocationData(R.string.attraction_grashaus, R.string.attraction_address_grashaus, R.drawable.aachen_grashaus,
                Uri.parse("https://www.google.de/maps/place/Grashaus/@50.7744039,6.080605,17z/data=!3m1!4b1!4m5!3m4!1s0x47c0997c94ef11c9:0x9d2c248cf22e4fc3!8m2!3d50.7744005!4d6.0827937")));
        locations.add(new LocationData(R.string.attraction_couven_museum, R.string.attraction_address_couven_museum, R.drawable.couven_museum_aachen,
                Uri.parse("https://www.google.de/maps/place/Couven-Museum/@50.775654,6.0827481,17z/data=!3m1!4b1!4m5!3m4!1s0x47c0997b55b0484f:0x9c9ccd4de10734f6!8m2!3d50.7756506!4d6.0849368")));


        // creates a new objective with the Data from the LocationDataAdapter Class
        // and the parameters to use this activity and the data from this activity
        LocationDataAdapter adapter = new LocationDataAdapter(getActivity(), locations, R.color.category_attractions);

        //stores in the variable listView the information about the xml list
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // sets the adapter on the listView with all the information
        listView.setAdapter(adapter);

        // this sets an ClickListener on the listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                // this gets the data from the ArrayList
                LocationData locationUri = locations.get(position);

                //here is an intent created that opens information on google maps about the attractions
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri.geturiLocation());
                startActivity(mapIntent);
            }
        });

        return rootView;
    }
}






