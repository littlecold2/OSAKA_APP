package littlecold2.osaka_app;

import android.app.Activity;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static DataManager instance = null;
    private Activity activity;

    public List<Loc_data> loc_list = new ArrayList<>();
//    public String loc_title = "오사카";
//    public String loc_snippet = "여행의 모든 것";

    private DataManager(){
        loc_list.add(new Loc_data("오사카","여행의 모든 것",new LatLng( 34.6,135.5)));

        //생성자앞에 private으로 선언하면서,

        //다른 클래스에서 new 키워드를 사용하여 인스턴스를 만들 수 있는 여지를 막음.



    }

    public static DataManager getInstance(){
        if(instance == null){
            instance = new DataManager();
        }
        return instance;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;

    }

}



