package littlecold2.osaka_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends  AnimatedExpandableListView.AnimatedExpandableListAdapter {

        private LayoutInflater inflater;
        private ChildViewHolder childViewHolder;
        private ParentViewHolder parentViewHolder;
        private List<ParentData> parentDataList;
        private List<ChildData> childDataList;
        private Context mContext;


//        private List<ChildData> items;


        public ListViewAdapter(Context context, List<ParentData>parentDataList) {
            inflater = LayoutInflater.from(context);
            this.mContext = context;
            this.parentDataList = parentDataList;
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
            ChildViewHolder holder;
//            MainActivity.ChildItem item = getChild(groupPosition, childPosition);
            ChildData childData = getChild(groupPosition,childPosition);
            if (convertView == null) {
//                holder = new MainActivity.ChildHolder();
                holder = new ChildViewHolder();
                convertView = inflater.inflate(R.layout.list_child, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.textTitle);
                holder.hint = (TextView) convertView.findViewById(R.id.textHint);
                holder.img = (ImageView) convertView.findViewById(R.id.child_item_icon);
                convertView.setTag(holder);
            } else {
//                holder = (MainActivity.ChildHolder) convertView.getTag();
                holder = (ChildViewHolder) convertView.getTag();
            }

//            holder.title.setText(item.title);
//            holder.hint.setText(item.hint);
            holder.title.setText(childData.title);
            holder.hint.setText(childData.hint);
            String resName = "@drawable/ic_favorites";

//             결론적으로 이미지 리소스 이름은 img_1, img_2, img_3 이 되겠다;

            int resID = mContext.getResources().getIdentifier(resName, "drawable", mContext.getPackageName());

            holder.img.setImageResource(resID);


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
