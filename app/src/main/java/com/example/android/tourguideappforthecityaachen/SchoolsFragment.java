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
public class SchoolsFragment extends Fragment {


    public SchoolsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.information_list, container, false);


        final ArrayList<LocationData> locations = new ArrayList<LocationData>();
        locations.add(new LocationData(R.string.schools_abendgymnasium_aachen, R.string.schools_address_abendgymnasium_aachen, R.drawable.abendgymnasium_aachen,
                Uri.parse("https://www.google.de/maps/place/Abendgymnasium+Aachen/@50.8050134,6.0495913,17z/data=!3m1!4b1!4m5!3m4!1s0x47c099c83c9460b3:0xc689d9669b1fc73f!8m2!3d50.80501!4d6.05178")));
        locations.add(new LocationData(R.string.schools_abendrealschule, R.string.schools_address_abendrealschule, R.drawable.abendrealschule,
                Uri.parse("https://www.google.de/maps/place/Abendrealschule/@50.7776639,6.1046954,17z/data=!3m1!4b1!4m5!3m4!1s0x47c0995b0e0ff761:0xa84f47451b79924!8m2!3d50.7776605!4d6.1068841")));
        locations.add(new LocationData(R.string.schools_rwth_aachen, R.string.schools_address_rwth_aachen, R.drawable.rwth_university,
                Uri.parse("https://www.google.de/maps/place/RWTH+Aachen+University/@50.7800812,6.0634982,17z/data=!3m1!4b1!4m5!3m4!1s0x47c09979a153d7b5:0x8916c62aa69322e7!8m2!3d50.7800778!4d6.0656869")));
        locations.add(new LocationData(R.string.schools_fh_aachen, R.string.schools_address_fh_aachen, R.drawable.fh,
                Uri.parse("https://www.google.de/maps/place/FH+Aachen/@50.754799,6.0793345,14z/data=!4m8!1m2!2m1!1sfh+aachen!3m4!1s0x41722d05f1737db7:0x9a7eb562b5677c74!8m2!3d50.754799!4d6.096844")));
        locations.add(new LocationData(R.string.schools_kaiser_karls_gymnasium, R.string.schools_address_kaiser_karls_gymnasium, R.drawable.kaiser_karls_gymnasium,
                Uri.parse("https://www.google.de/maps/place/Kaiser-Karls-Gymnasium/@50.7768868,6.0794474,17z/data=!3m1!4b1!4m5!3m4!1s0x47c0997b9932aad7:0xa51d8305abafb41b!8m2!3d50.7768834!4d6.0816361")));
        locations.add(new LocationData(R.string.schools_schule_am_lousberg, R.string.schools_address_schule_am_lousberg, R.drawable.lousberg_schule,
                Uri.parse("https://www.google.de/maps/place/Schule+am+Lousberg/@50.7818157,6.0822307,17z/data=!3m1!4b1!4m5!3m4!1s0x47c0997072adce67:0x9664594d838406a1!8m2!3d50.7818123!4d6.0844194")));
        locations.add(new LocationData(R.string.schools_4__gesamtschule_aachen, R.string.schools_address_4__gesamtschule_aachen, R.drawable.gesamtschule_aachen,
                Uri.parse("https://www.google.de/maps/place/4.+Gesamtschule+der+Stadt+Aachen/@50.7806804,6.0853888,17z/data=!3m1!4b1!4m5!3m4!1s0x47c099655fa24f55:0x6ba7c1fd094be3a2!8m2!3d50.780677!4d6.0875775")));

        LocationDataAdapter adapter = new LocationDataAdapter(getActivity(), locations, R.color.category_schools);

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


