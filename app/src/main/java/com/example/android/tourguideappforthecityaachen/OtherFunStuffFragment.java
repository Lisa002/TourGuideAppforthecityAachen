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
public class OtherFunStuffFragment extends Fragment {


    public OtherFunStuffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.information_list, container, false);
        final ArrayList<LocationData> locations = new ArrayList<LocationData>();
        locations.add(new LocationData(R.string.other_fun_stuff_boulderhall, R.string.other_fun_stuff_address_boulderhall, R.drawable.moove,
                Uri.parse("https://www.google.de/maps/place/Minimoove+Boulderhalle/@50.7670978,6.0931287,17z/data=!3m1!4b1!4m5!3m4!1s0x47c09bde3212868f:0xe980a3874f695d29!8m2!3d50.7670944!4d6.0953174")));
        locations.add(new LocationData(R.string.other_fun_stuff_raus_escape_room, R.string.other_fun_stuff_address_raus_escape_room, R.drawable.escaperoom,
                Uri.parse("https://www.google.de/maps/place/Raus!+Escape+Room+Aachen/@50.770498,6.1053177,17z/data=!3m1!4b1!4m5!3m4!1s0x47c09bd5792dad57:0x507891a8e16728ce!8m2!3d50.7704946!4d6.1075064")));
        locations.add(new LocationData(R.string.other_fun_stuff_virtual_area, R.string.other_fun_stuff_address_virtual_area, R.drawable.virtual_area,
                Uri.parse("https://www.google.de/maps/place/Virtual+Area/@50.7738721,6.0958138,17z/data=!3m1!4b1!4m5!3m4!1s0x47c0995e19333697:0x35e99cbb75f8fa01!8m2!3d50.7738745!4d6.097936")));
        locations.add(new LocationData(R.string.other_fun_stuff_cineplex, R.string.other_fun_stuff_address_cineplex, R.drawable.cineplex_aachen,
                Uri.parse("https://www.google.de/maps/place/Cineplex+Aachen/@50.7714114,6.0848258,17z/data=!3m1!4b1!4m5!3m4!1s0x47c09bd87f4d8317:0xca84d85c223478d6!8m2!3d50.771408!4d6.0870145")));
        locations.add(new LocationData(R.string.other_fun_stuff_carolus_thermen, R.string.other_fun_stuff_address_carolus_thermen, R.drawable.carolus_thermen,
                Uri.parse("https://www.google.de/maps/place/Carolus+Thermen/@50.7830341,6.0947884,17z/data=!3m1!4b1!4m5!3m4!1s0x47c09969b856f3fd:0xbf0cac7ca8d8ac24!8m2!3d50.7830307!4d6.0969771")));
        locations.add(new LocationData(R.string.other_fun_stuff_aachener_tierpark_euregiozoo, R.string.other_fun_stuff_address_aachener_tierpark_euregiozoo, R.drawable.zoo_aachen,
                Uri.parse("https://www.google.de/maps/place/Aachener+Tierpark+Euregiozoo/@50.763828,6.1130539,17z/data=!3m1!4b1!4m5!3m4!1s0x47c09bfeb5ab78ed:0x6d5ba4758a5eb705!8m2!3d50.7638246!4d6.1152426")));
        locations.add(new LocationData(R.string.other_fun_stuff_drehturm_belvedere_aachen, R.string.other_fun_stuff_address_drehturm_belvedere_aachen, R.drawable.drehturm,
                Uri.parse("https://www.google.de/maps/place/Drehturm+Belvedere+Aachen/@50.7864712,6.0782864,17z/data=!3m1!4b1!4m5!3m4!1s0x47c0997108560d31:0xa9313141cf7be670!8m2!3d50.7864678!4d6.0804751")));


        // creates a new objective with the Data from the LocationDataAdapter Class
        // and the parameters to use this activity and the data from this activity
        LocationDataAdapter adapter = new LocationDataAdapter(getActivity(), locations, R.color.category_other_fun_stuff);

        //stores in the variable listView the information about the xml list
         ListView listView = (ListView) rootView.findViewById(R.id.list);

        // sets the adapter on the listView with all the information
        listView.setAdapter(adapter);

        // this sets an ClickListener on the listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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


