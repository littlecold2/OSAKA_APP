package littlecold2.osaka_app;

import android.widget.ImageView;
import android.widget.TextView;

class ChildViewHolder {
//    / * CustomListView의 구성요소에 대한 Holder 생성 */
//    // Drawable을 받을 ImageView
//    public ImageView mChildListViewIcon;
//    // String mText01을 받을 TextView
//    public TextView mChildListViewText;
//    // String mText02를 받을 TextView
//    public TextView mListText02Holder;
//    출처: http://straight-strange.tistory.com/11?category=867832 [straight 혹은 strange]

    TextView title;
    TextView hint;
    ImageView info;
    ImageView loc;
    ImageView favor;
    ChildViewHolder()
    {

    }
    ChildViewHolder(TextView title, TextView hint, ImageView info,ImageView loc,ImageView favor)
    {
        this.title = title;
        this. hint = hint;
        this.info = info;
        this.loc = loc;
        this.favor =favor;
    }

    public void setHint(TextView hint) {
        this.hint = hint;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

//    public void setImg(ImageView img) {
//        this.img = img;
//    }
}
