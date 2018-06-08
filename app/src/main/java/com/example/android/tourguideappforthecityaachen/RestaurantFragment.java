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
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.information_list, container, false);

        final ArrayList<LocationData> locations = new ArrayList<LocationData>();
        locations.add(new LocationData(R.string.restaurant_kanpai_sushi_running_sushi, R.string.restaurant_address_kanpai_sushi_running_sushi, R.drawable.kanpai,
                Uri.parse("https://www.google.de/maps/place/Kanpai+Sushi,+Running+Sushi/@50.7864712,6.0782864,17z/data=!4m5!3m4!1s0x47c0996503f30ae5:0x7c981f04f1d3acb7!8m2!3d50.77843!4d6.088424")));
        locations.add(new LocationData(R.string.restaurant_restaurant_aix_mediterrena, R.string.restaurant_address_restaurant_aix_mediterrena, R.drawable.aix_mediteran,
                Uri.parse("https://www.google.de/maps/place/Aix+Mediterrena/@50.7758744,6.0826053,17z/data=!3m1!4b1!4m5!3m4!1s0x47c0997b54d68459:0x2cfa661cae06ea2a!8m2!3d50.775871!4d6.084794")));
        locations.add(new LocationData(R.string.restaurant_maredo_steakhouse_sachen, R.string.restaurant_address_maredo_steakhouse_sachen, R.drawable.maredo_aachen,
                Uri.parse("https://www.google.de/maps/place/MAREDO+Steakhouse+Aachen/@50.7736394,6.0875238,17z/data=!3m1!4b1!4m5!3m4!1s0x47c09964119f4df7:0x599cff186b2ec001!8m2!3d50.773636!4d6.0897125")));
        locations.add(new LocationData(R.string.restaurant_pfannenzauber, R.string.restaurant_address_pfannenzauber, R.drawable.pfannenzauber,
                Uri.parse("https://www.google.de/maps/place/Pfannenzauber/@50.7736394,6.0875238,17z/data=!4m5!3m4!1s0x47c099616219f62f:0x625495c868b7013d!8m2!3d50.773624!4d6.0911546")));
        locations.add(new LocationData(R.string.restaurant_pontgrill, R.string.restaurant_address_pontgrill, R.drawable.pontgrill,
                Uri.parse("https://www.google.de/maps/place/Pontgrill/@50.7736274,6.0889659,17z/data=!4m5!3m4!1s0x47c0997a19a43df9:0xfa28c8eb89d11b52!8m2!3d50.7800453!4d6.0802222")));
        locations.add(new LocationData(R.string.restaurant_ozaki_sushi_grill, R.string.restaurant_address_ozaki_sushi_grill, R.drawable.ozaki_aachen,
                Uri.parse("https://www.google.de/maps/place/OZAKI+Sushi+%26+Grill/@50.7800653,6.0714674,15z/data=!4m8!1m2!2m1!1sozaki!3m4!1s0x47c0996411089e01:0xcf1149879a0ff8de!8m2!3d50.7760753!4d6.0909405")));
        locations.add(new LocationData(R.string.restaurant_essbar, R.string.restaurant_address_essbar, R.drawable.essbar,
                Uri.parse("https://www.google.de/maps/place/essBar/@50.7800653,6.0714674,15z/data=!4m5!3m4!1s0x47c0997a3e86d407:0x7c6819cdad2b2f71!8m2!3d50.7796!4d6.08067")));


        // creates a new objective with the Data from the LocationDataAdapter Class
        // and the parameters to use this activity and the data from this activity
        LocationDataAdapter adapter = new LocationDataAdapter(getActivity(), locations, R.color.category_restaurant);

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
