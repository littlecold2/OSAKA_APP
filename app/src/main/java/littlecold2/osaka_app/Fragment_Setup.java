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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Iiro Krankka (http://github.com/roughike)
 */
public class Fragment_Setup extends Fragment {

    public Fragment_Setup() {
    }

//    public static MainFragment newInstance(String text) {
////        Bundle args = new Bundle();
////
////        MainFragment sampleFragment = new MainFragment();
////        sampleFragment.setArguments(args);
////
////        return sampleFragment;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_up, container, false);
    }
}
