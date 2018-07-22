package littlecold2.osaka_app;

import com.google.android.gms.maps.model.LatLng;

public class Loc_data {

    String name;
    String snippet;
    LatLng latLng;

    Loc_data(String name, String snippet, LatLng latLng)
    {
        this.name = name;
        this. snippet = snippet;
        this.latLng = latLng;
    }

}
