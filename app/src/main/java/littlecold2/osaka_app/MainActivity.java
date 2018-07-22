package littlecold2.osaka_app;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private TextView messageView;
    private Fragment_Main mainFragment;
    private Fragment_Map mapFragment;
    private Fragment_Setup setupFragment;
    BottomBar bottomBar;
    private DataManager dataManager= DataManager.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataManager.setActivity(this);

        mainFragment = new Fragment_Main();
        mapFragment = new Fragment_Map();
        setupFragment =  new Fragment_Setup();

        initFragment();

        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                if(tabId == R.id.tab_recents){
                    transaction.replace(R.id.contentContainer, mainFragment).commit();
                }

                else if(tabId == R.id.tab_map){
                    transaction.replace(R.id.contentContainer, mapFragment).commit();

                }

                else if(tabId == R.id.tab_favorites){
                    transaction.replace(R.id.contentContainer, setupFragment).commit();

                }
            }
        });
        BottomBarTab nearby = bottomBar.getTabWithId(R.id.tab_favorites);
        nearby.setBadgeCount(5);

    }


    // app실행시 보여주는 Fragment 설정
    public void initFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.contentContainer, mainFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
