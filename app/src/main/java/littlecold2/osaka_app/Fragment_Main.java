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

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Main extends Fragment {

    DataManager dataManager = DataManager.getInstance();
    private AnimatedExpandableListView listView;
    private ListViewAdapter adapter;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);




//                return super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        // Inflate the layout for this fragment
        Log.d("fragment_main","F_M");
        List<ParentData> parentDataList = new ArrayList<ParentData>();

        // Populate our list with groups and it's children
        for(int i = 1; i < 4; i++) {
            ParentData parentData = new ParentData("Group " + i,i);

//            parentData.title = "Group " + i;

            for(int j = 0; j < i; j++) {
                ChildData child = new ChildData("Awesome item " + j,"Too awesome");
//                child.title = "Awesome item " + j;
//                child.hint = "Too awesome";
//
                parentData.childDataList.add(child);
            }

//            items.add(item);
            parentDataList.add(parentData);
        }

        adapter = new ListViewAdapter(getContext(),parentDataList);
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
                }
                return true;
            }

        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(groupPosition)+" "+Integer.toString(childPosition),Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }// onViewCreated



}
