package littlecold2.osaka_app;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class ListViewAdapter extends  AnimatedExpandableListView.AnimatedExpandableListAdapter {

        private LayoutInflater inflater;
        private ChildViewHolder childViewHolder;
        private ParentViewHolder parentViewHolder;
        private List<ParentData> parentDataList;
        private List<ChildData> childDataList;
        private Context mContext;
        ChildViewHolder holder;
        int gp;
        int cp;

    DataManager dataManager = DataManager.getInstance();

//        private List<ChildData> items;

        Fragment_Map mapFragment;


        public ListViewAdapter(Context context, List<ParentData>parentDataList) {
            inflater = LayoutInflater.from(context);
            this.mContext = context;
            this.parentDataList = parentDataList;
            mapFragment = new Fragment_Map();
//            this.childDataList = childList;
        }
//
//        public void setData(List<MainActivity.GroupItem> items) {
//            this.items = items;
//        }

        @Override
        public ChildData getChild(int groupPosition, int childPosition) {
            return parentDataList.get(groupPosition).childDataList.get(childPosition);
//            return items.get(groupPosition).items.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//            MainActivity.ChildHolder holder;


//            MainActivity.ChildItem item = getChild(groupPosition, childPosition);
             ChildData childData = getChild(groupPosition,childPosition);
            Log.d("dddd", "gp: "+String.valueOf(groupPosition));
            if (convertView == null) {
                gp = groupPosition;
                cp =childPosition;
                Log.d("dddd","getReal");
//                holder = new MainActivity.ChildHolder();
                holder = new ChildViewHolder();
                convertView = inflater.inflate(R.layout.list_child, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.textTitle);
                holder.hint = (TextView) convertView.findViewById(R.id.textHint);
                holder.info = (ImageView) convertView.findViewById(R.id.child_item_info);
                holder.loc = (ImageView) convertView.findViewById(R.id.child_item_loc);
                holder.favor = (ImageView) convertView.findViewById(R.id.child_item_favor);
                holder.loc.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
//                            Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(groupPosition)+" "+Integer.toString(childPosition),Toast.LENGTH_SHORT).show();
//                    FragmentTransaction transaction = ((MainActivity)dataManager.getActivity()).getSupportFragmentManager().beginTransaction();

                        if(dataManager.loc_list.size()==1&& dataManager.loc_list.get(0).name.equals("오사카"))
                            dataManager.loc_list.clear();

                        if(!dataManager.loc_list.contains(parentDataList.get(gp).latLng))
                            dataManager.loc_list.add(new Loc_data(parentDataList.get(gp).title,parentDataList.get(gp).snippet,parentDataList.get(gp).latLng));

                        Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(gp)+" "+Integer.toString(cp)+", "+parentDataList.get(gp).latLng.toString(),Toast.LENGTH_SHORT).show();

//                transaction.addToBackStack(null);
//                transaction.replace(R.id.contentContainer, mapFragment).commit();
                        ((MainActivity) dataManager.getActivity()).bottomBar.selectTabAtPosition(1,true);
                    }
                });
                holder.info.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
//                            Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(groupPosition)+" "+Integer.toString(childPosition),Toast.LENGTH_SHORT).show();
//                    FragmentTransaction transaction = ((MainActivity)dataManager.getActivity()).getSupportFragmentManager().beginTransaction();

                        Intent intent = new Intent(dataManager.getActivity().getApplicationContext(), ScrollingActivity.class);
//                        intent.putExtra(KEY_BEFORE_USER_DATA, userInfo);
                        dataManager.getActivity().startActivity(intent);
                        Toast.makeText(dataManager.getActivity().getApplicationContext(),Integer.toString(gp)+" "+Integer.toString(cp)+", "+parentDataList.get(gp).latLng.toString(),Toast.LENGTH_SHORT).show();


                    }
                });



                convertView.setTag(holder);
            } else {
                Log.d("dddd","getReal_else");
                gp = groupPosition;
                cp =childPosition;
//                holder = (MainActivity.ChildHolder) convertView.getTag();
                holder = (ChildViewHolder) convertView.getTag();
            }

//            holder.title.setText(item.title);
//            holder.hint.setText(item.hint);
            holder.title.setText(childData.title);
            holder.hint.setText(childData.hint);
            String resName = "@drawable/ic_favorites";

//             결론적으로 이미지 리소스 이름은 img_1, img_2, img_3 이 되겠다;

            int resID1 = mContext.getResources().getIdentifier("@drawable/ic_restaurants", "drawable", mContext.getPackageName());
            int resID2 = mContext.getResources().getIdentifier("@drawable/ic_nearby","drawable", mContext.getPackageName());
            int resID3 = mContext.getResources().getIdentifier("@drawable/ic_favorites","drawable" ,mContext.getPackageName());

            holder.info.setImageResource(resID1);
            holder.loc.setImageResource(resID2);
            holder.favor.setImageResource(resID3);


            return convertView;
        }

        @Override
        public int getRealChildrenCount(int groupPosition) {
            return parentDataList.get(groupPosition).childDataList.size();
        }

//        @Override
//        public MainActivity.GroupItem getGroup(int groupPosition) {
//            return parentDataList.get(groupPosition);
//        }
        @Override
        public ParentData getGroup(int groupPosition) {
            return parentDataList.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return parentDataList.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//            MainActivity.GroupHolder holder;
            ParentViewHolder holder;
            ParentData parentData = getGroup(groupPosition);
            if (convertView == null) {
                holder = new ParentViewHolder();
                convertView = inflater.inflate(R.layout.list_parent, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.sight_name);
                holder.sight_img = (ImageView)convertView.findViewById(R.id.sight_img);
                convertView.setTag(holder);
            } else {
                holder = (ParentViewHolder) convertView.getTag();
            }

            String resName = "@drawable/sight_"+ parentData.img_index;

//             결론적으로 이미지 리소스 이름은 img_1, img_2, img_3 이 되겠다;

            int resID = mContext.getResources().getIdentifier(resName, "drawable", mContext.getPackageName());

            holder.title.setText(parentData.title);
            holder.sight_img.setImageResource(resID);
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            return true;
        }


}
