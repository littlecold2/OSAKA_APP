package littlecold2.osaka_app;

import android.widget.ImageView;
import android.widget.TextView;

class ParentViewHolder {
//    / * CustomListView의 구성요소에 대한 Holder 생성 */
//    // Drawable을 받을 ImageView
//    public ImageView mChildListViewIcon;
//    // String mText01을 받을 TextView
//    public TextView mChildListViewText;
//    // String mText02를 받을 TextView
//    public TextView mListText02Holder;
//
////    출처: http://straight-strange.tistory.com/11?category=867832 [straight 혹은 strange]

    ImageView sight_img;
    TextView title;

    ParentViewHolder()
    {
    }
    ParentViewHolder(TextView title)
    {
        this.title = title;
    }

}
