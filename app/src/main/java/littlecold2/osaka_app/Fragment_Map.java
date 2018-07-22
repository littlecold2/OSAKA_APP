/*
 * BottomBar library for Android
 * Copyright (c) 2016 Iiro Krankka (http://github.com/roughike).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package littlecold2.osaka_app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Iiro Krankka (http://github.com/roughike)
 */
public class Fragment_Map extends Fragment implements OnMapReadyCallback {

    DataManager dataManager = DataManager.getInstance();
    private MapView mapView;
    private GoogleMap googleMap;

    public Fragment_Map() {
    }

    @Override
    public void onResume() {
//        ((MainActivity) dataManager.getActivity()).bottomBar.selectTabAtPosition(1,true);

        super.onResume();
    }

//    public static MainFragment newInstance(String text) {
////        Bundle args = new Bundle();
////
////        MainFragment sampleFragment = new MainFragment();
////        sampleFragment.setArguments(args);
////
////        return sampleFragment;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_map,container,false);


//        // Inflate the layout for this fragment
//        return super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);//
    }


    @Override
    public void onMapReady(GoogleMap map) {
        LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        for(Loc_data loc_data:dataManager.loc_list)
        {
            Log.d("dddd", String.valueOf(dataManager.loc_list.size()));
            markerOptions.position(loc_data.latLng);
            markerOptions.title(loc_data.name);
            markerOptions.snippet(loc_data.snippet);
            map.addMarker(markerOptions).showInfoWindow();

        }

        map.getUiSettings().setZoomControlsEnabled(true);
        if(dataManager.loc_list.size()>0)
            map.moveCamera(CameraUpdateFactory.newLatLng(dataManager.loc_list.get(dataManager.loc_list.size()-1).latLng));
//        else
//        {
//            markerOptions.position(loc);
//            markerOptions.title(dataManager.loc_title);
//            markerOptions.snippet(dataManager.loc_snippet);
//            map.addMarker(markerOptions).showInfoWindow();
//            new LatLng(34.6,135.5);
//
//        }
        map.animateCamera(CameraUpdateFactory.zoomTo(14));
    }

}
