package littlecold2.osaka_app;

import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

class ParentData {

//    * CustomListView가 담을 객체에 대한 Class 생성 */
//    // ImageView에 상응
//    public Drawable mChildItem;
//    // TextView01에 상응
//    public String mChildText;
//    // TextView02에 상응
//    public String mTest02;
    int img_index;
    String title;
    String snippet;
    List<ChildData> childDataList;
    LatLng latLng;


    public ParentData(String title,String snippet, int img_index, LatLng latLng) {
        this.title =title;
        this.snippet= snippet;
        this.img_index =img_index;
        this.latLng = latLng;
        childDataList  = new ArrayList<ChildData>();
    }

//    출처: http://straight-strange.tistory.com/11?category=867832 [straight 혹은 strange]

}
