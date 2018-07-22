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
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Main extends Fragment {

    DataManager dataManager = DataManager.getInstance();
    private AnimatedExpandableListView listView;
    private ListViewAdapter adapter;
    List<ParentData> parentDataList;
    List<LatLng> loc_list;

    @Override
    public void onResume() {
//        ((MainActivity) dataManager.getActivity()).bottomBar.selectTabAtPosition(0,true);
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("fragment_main","F_M");
        parentDataList = new ArrayList<ParentData>();
        loc_list = new ArrayList<>();

//        for (int i=0;i<4;i++) {
            loc_list.add(new LatLng(34.6873153, 135.5262013));
            loc_list.add(new LatLng(34.6853153, 135.5262013));
            loc_list.add(new LatLng(34.6833153, 135.5262013));
            loc_list.add(new LatLng(34.6813153, 135.5262013));
//            Log.d("dddd","first, "+loc_list.get(i).toString());
//        }
        // Populate our list with groups and it's children
        for(int i = 0; i < 4; i++) {
            ParentData parentData = new ParentData("Group " + i,"snippet"+i,i,loc_list.get(i));

//            parentData.title = "Group " + i;

//            for(int j = 0; j < i; j++) {
            Log.d("dddd","second, "+loc_list.get(i).toString());

            ChildData child = new ChildData("Awesome item " + 1,"Too awesome");
//                child.title = "Awesome item " + j;
//                child.hint = "Too awesome";
//
            parentData.childDataList.add(child);
//            }

//            items.add(item);
            parentDataList.add(parentData);
        }

        adapter = new ListViewAdapter(getContext(),parentDataList);



//                return super.onCreateView(inflater, container, savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);

        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //        // Inflate the layout for this fragment

//        adapter.setData(items);

        listView = (AnimatedExpandableListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // In order to show animations, we need to use a custom click handler
        // for our ExpandableListView.

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (listView.isGroupExpanded(groupPosition)) {
                    listView.collapseGroupWithAnimation(groupPosition);

                } else {

                    listView.expandGroupWithAnimation(groupPosition);
                    for(int i=0;i<listView.getCount();i++) {
                        if(i!=groupPosition)
                            listView.collapseGroupWithAnimation(i);
                    }
                }
                return true;
            }

        });




//
//        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, final int groupPosition, final int childPosition, long id) {
//
//                Log.d("dddd", String.valueOf(parent.isFocused()));
////                parent.performItemClick(v,childPosition,id)
//
////                            Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(groupPosition)+" "+Integer.toString(childPosition),Toast.LENGTH_SHORT).show();
////                    FragmentTransaction transaction = ((MainActivity)dataManager.getActivity()).getSupportFragmentManager().beginTransaction();
//                if (v.findViewById(R.id.child_item_loc).isPressed())
//                {
//                    if(!dataManager.loc_list.contains(parentDataList.get(groupPosition).latLng))
//                            dataManager.loc_list.add(parentDataList.get(groupPosition).latLng);
//
//                        Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(groupPosition)+" "+Integer.toString(childPosition)+", "+dataManager.loc_list.get(groupPosition).toString(),Toast.LENGTH_SHORT).show();
//                        dataManager.loc_title = "오사카 성";
//                        dataManager.loc_snippet = "일본의 성";
////                transaction.addToBackStack(null);
////                transaction.replace(R.id.contentContainer, mapFragment).commit();
//                        ((MainActivity) dataManager.getActivity()).bottomBar.selectTabAtPosition(1,true);
//
//                    v.findViewById(R.id.child_item_loc).performClick();
//                }
////                v.findViewById(R.id.child_item_loc).setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View view) {
////                        if(!dataManager.loc_list.contains(parentDataList.get(groupPosition).latLng))
////                            dataManager.loc_list.add(parentDataList.get(groupPosition).latLng);
////
////                        Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(groupPosition)+" "+Integer.toString(childPosition)+", "+dataManager.loc_list.get(groupPosition).toString(),Toast.LENGTH_SHORT).show();
////                        dataManager.loc_title = "오사카 성";
////                        dataManager.loc_snippet = "일본의 성";
//////                transaction.addToBackStack(null);
//////                transaction.replace(R.id.contentContainer, mapFragment).commit();
////                        ((MainActivity) dataManager.getActivity()).bottomBar.selectTabAtPosition(1,true);
////
////                    }
////                });
//
//
//
////                v.findViewById(R.id.child_item_loc).setClickable(true);
//                // 누른게 이미지 뷰면 하는거로 하는게 나을듯????????????????????/
////                if(v.findViewById(R.id.child_item_loc).set)
////                {
////                    Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(groupPosition)+" "+Integer.toString(childPosition),Toast.LENGTH_SHORT).show();
////
////                }
////                v.findViewById(R.id.child_item_loc) .setOnClickListener(new View.OnClickListener()
////                {
////                    @Override
////                    public void onClick(View view) {
////                            Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(groupPosition)+" "+Integer.toString(childPosition),Toast.LENGTH_SHORT).show();
////                    }
////                });
//
////                Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(groupPosition)+" "+Integer.toString(childPosition),Toast.LENGTH_SHORT).show();
////                FragmentTransaction transaction = ((MainActivity)dataManager.getActivity()).getSupportFragmentManager().beginTransaction();
//////                Fragment_Map mapFragment;
//////                mapFragment = new Fragment_Map();
////
////                dataManager.loc_latLng = new LatLng(34.6873153,135.5262013);
////                dataManager.loc_title = "오사카 성";
////                dataManager.loc_snippet = "일본의 성";
////                transaction.addToBackStack(null);
////                transaction.replace(R.id.contentContainer, new Fragment_Map()).commit();
//
//                return false;
//            }
//        });




    }// onViewCreated



}
